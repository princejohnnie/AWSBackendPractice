package com.princejohnnie.awspractice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class ReportResponse {
    private String accountId;
    private String iamUser;
    private String keyLastRotated;
    private String dayCount;
    @JsonProperty(value = "STATUS")
    private Status status;

    public ReportResponse() {
    }

    public ReportResponse(String accountId, String iamUser, String keyLastRotated, String dayCount, Status status) {
        this.accountId = accountId;
        this.iamUser = iamUser;
        this.keyLastRotated = keyLastRotated;
        this.dayCount = dayCount;
        this.status = status;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getIamUser() {
        return iamUser;
    }

    public void setIamUser(String iamUser) {
        this.iamUser = iamUser;
    }

    public String getKeyLastRotated() {
        return keyLastRotated;
    }

    public void setKeyLastRotated(String keyLastRotated) {
        this.keyLastRotated = keyLastRotated;
    }

    public String getDayCount() {
        return dayCount;
    }

    public void setDayCount(String dayCount) {
        this.dayCount = dayCount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
