package com.princejohnnie.awspractice.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.princejohnnie.awspractice.model.ReportResponse;
import com.princejohnnie.awspractice.service.AWSService;
import com.princejohnnie.awspractice.model.ImageResponse;
import com.princejohnnie.awspractice.request.AMIRequest;
import com.princejohnnie.awspractice.response.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;


@RestController
@RequestMapping("/security-audit")
public class AWSController {

    @Autowired
    private AWSService service;

    @GetMapping("/ec2/public-amis")
    public ResponseEntity<Object> getPublicAMIs(@RequestBody AMIRequest request) {
        try {
            List<String> regions = request.getRegions();

            Future<List<ImageResponse>> futureResponse = service.getAMIs(regions);

            while (true) {
                if (futureResponse.isDone()) {
                    if (futureResponse.get() != null) {
                        return ResponseHandler.getResponse(HttpStatus.OK, futureResponse.get());
                    } else {
                        return ResponseHandler.getResponse(HttpStatus.NOT_FOUND, null);
                    }
                }
            }

        } catch (Exception e) {
            return ResponseHandler.getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

    @GetMapping("/iam/rotation-check")
    public ResponseEntity<Object> getIAMUsers() {

        try {
            List<ReportResponse> responses = service.getIAMUsers();

            return ResponseHandler.getResponse(HttpStatus.OK, responses);

        } catch (Exception e) {

            return ResponseHandler.getErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

    }

}
