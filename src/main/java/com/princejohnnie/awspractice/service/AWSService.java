package com.princejohnnie.awspractice.service;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2AsyncClientBuilder;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagement;
import com.amazonaws.services.identitymanagement.AmazonIdentityManagementClientBuilder;
import com.amazonaws.services.identitymanagement.model.GenerateCredentialReportResult;
import com.amazonaws.services.identitymanagement.model.GetCredentialReportResult;
import com.princejohnnie.awspractice.model.ImageResponse;
import com.princejohnnie.awspractice.model.ReportResponse;
import com.princejohnnie.awspractice.model.Status;
import com.princejohnnie.awspractice.model.UserResponse;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Service
public class AWSService {

    @Async
    public Future<List<ImageResponse>> getAMIs(List<String> regions) {

        for (String regionName : regions) {
            Regions region = Regions.fromName(regionName);

            AmazonEC2 ec2 = AmazonEC2AsyncClientBuilder.standard()
                    .withCredentials(new ProfileCredentialsProvider("C:\\Users\\princejohnnie\\.aws\\credentials", "johnny"))
                    .withRegion(region)
                    .build();

            DescribeImagesResult describeImages = ec2.describeImages();

            List<Image> images = describeImages.getImages();

            List<ImageResponse> response = images.stream().map(image ->
                    new ImageResponse(image.getOwnerId(), region.getName(), image.getImageId(), image.getImageType(), image.getCreationDate(), image.isPublic() ? Status.CRITICAL : Status.OK)).collect(Collectors.toList());

            return new AsyncResult<>(response);
        }
        return null;
    }


    public List<ReportResponse> getIAMUsers() {

        AmazonIdentityManagement iam = AmazonIdentityManagementClientBuilder
                .standard()
                .withCredentials(new ProfileCredentialsProvider("C:\\Users\\princejohnnie\\.aws\\credentials", "johnny"))
                .build();

        iam.generateCredentialReport();

        GetCredentialReportResult reportResult = iam.getCredentialReport();

        ByteBuffer buffer = reportResult.getContent();


        try (ICsvBeanReader beanReader = new CsvBeanReader(new InputStreamReader(new ByteArrayInputStream(buffer.array())), CsvPreference.STANDARD_PREFERENCE)) {

            final String[] headers = beanReader.getHeader(true);

            UserResponse user;

            List<ReportResponse> responses = new ArrayList<>();

            while ((user = beanReader.read(UserResponse.class, headers)) != null) {
                long dateCount;
                String keyLastRotated;

                if (user.isAccess_key_1_active().equalsIgnoreCase("true")) {
                    keyLastRotated = user.getAccess_key_1_last_rotated();
                    if (user.isAccess_key_2_active().equalsIgnoreCase("true")) {
                        keyLastRotated = user.getAccess_key_2_last_rotated();
                    }
                } else {
                    keyLastRotated = user.getUser_creation_time();
                }

                long lastRotatedDateInLong =  DatatypeConverter.parseDateTime(keyLastRotated).getTime().getTime();

                dateCount = System.currentTimeMillis() - lastRotatedDateInLong;

                dateCount = dateCount/(24 * 60 * 60 * 1000);

                responses.add(new ReportResponse(getIdFromArn(user.getArn()), user.getUser(), keyLastRotated, String.valueOf(dateCount), dateCount > 30 ? Status.CRITICAL : Status.OK));

            }

            return responses;

        } catch (IOException e) {
            System.out.println("Cannot parse csv because -> " + e.getMessage());
        }

        return null;
    }

    private long getDateDifference(String keyOneLastRotated, String keyTwoLastRotated) {

        Date keyOneDate = DatatypeConverter.parseDateTime(keyOneLastRotated).getTime();
        Date keyTwoDate = DatatypeConverter.parseDateTime(keyTwoLastRotated).getTime();

        long difference = keyTwoDate.getTime() - keyOneDate.getTime();

        return difference / (24 * 60 * 60 * 1000);
    }

    private String getIdFromArn(String arn) {
        return arn.substring(13, 25);
    }

}
