package com.princejohnnie.awspractice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageResponse {
    private String accountId;
    private String region;
    private String imageId;
    private String imageType;
    private String creationDate;
    @JsonProperty(value = "STATUS")
    private Status status;

    public ImageResponse(String accountId, String region, String imageId, String imageType, String creationDate, Status status) {
        this.accountId = accountId;
        this.region = region;
        this.imageId = imageId;
        this.imageType = imageType;
        this.creationDate = creationDate;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
