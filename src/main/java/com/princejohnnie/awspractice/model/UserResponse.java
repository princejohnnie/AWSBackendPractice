package com.princejohnnie.awspractice.model;

public class UserResponse {
    private String user;
    private String arn;
    private String user_creation_time;
    private String password_enabled;
    private String password_last_used;
    private String password_last_changed;
    private String password_next_rotation;
    private String mfa_active;
    private String access_key_1_active;
    private String access_key_1_last_rotated;
    private String access_key_1_last_used_date;
    private String access_key_1_last_used_region;
    private String access_key_1_last_used_service;
    private String access_key_2_active;
    private String access_key_2_last_rotated;
    private String access_key_2_last_used_date;
    private String access_key_2_last_used_region;
    private String access_key_2_last_used_service;
    private String cert_1_active;
    private String cert_1_last_rotated;
    private String cert_2_active;
    private String cert_2_last_rotated;

    public UserResponse() {
    }

    public UserResponse(String user, String arn, String user_creation_time, String password_enabled, String password_last_used, String password_last_changed, String password_next_rotation, String mfa_active, String access_key_1_active, String access_key_1_last_rotated, String access_key_1_last_used_date, String access_key_1_last_used_region, String access_key_1_last_used_service, String access_key_2_active, String access_key_2_last_rotated, String access_key_2_last_used_date, String access_key_2_last_used_region, String access_key_2_last_used_service, String cert_1_active, String cert_1_last_rotated, String cert_2_active, String cert_2_last_rotated) {
        this.user = user;
        this.arn = arn;
        this.user_creation_time = user_creation_time;
        this.password_enabled = password_enabled;
        this.password_last_used = password_last_used;
        this.password_last_changed = password_last_changed;
        this.password_next_rotation = password_next_rotation;
        this.mfa_active = mfa_active;
        this.access_key_1_active = access_key_1_active;
        this.access_key_1_last_rotated = access_key_1_last_rotated;
        this.access_key_1_last_used_date = access_key_1_last_used_date;
        this.access_key_1_last_used_region = access_key_1_last_used_region;
        this.access_key_1_last_used_service = access_key_1_last_used_service;
        this.access_key_2_active = access_key_2_active;
        this.access_key_2_last_rotated = access_key_2_last_rotated;
        this.access_key_2_last_used_date = access_key_2_last_used_date;
        this.access_key_2_last_used_region = access_key_2_last_used_region;
        this.access_key_2_last_used_service = access_key_2_last_used_service;
        this.cert_1_active = cert_1_active;
        this.cert_1_last_rotated = cert_1_last_rotated;
        this.cert_2_active = cert_2_active;
        this.cert_2_last_rotated = cert_2_last_rotated;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getArn() {
        return arn;
    }

    public void setArn(String arn) {
        this.arn = arn;
    }

    public String getUser_creation_time() {
        return user_creation_time;
    }

    public void setUser_creation_time(String user_creation_time) {
        this.user_creation_time = user_creation_time;
    }

    public String isPassword_enabled() {
        return password_enabled;
    }

    public void setPassword_enabled(String password_enabled) {
        this.password_enabled = password_enabled;
    }

    public String getPassword_last_used() {
        return password_last_used;
    }

    public void setPassword_last_used(String password_last_used) {
        this.password_last_used = password_last_used;
    }

    public String getPassword_last_changed() {
        return password_last_changed;
    }

    public void setPassword_last_changed(String password_last_changed) {
        this.password_last_changed = password_last_changed;
    }

    public String getPassword_next_rotation() {
        return password_next_rotation;
    }

    public void setPassword_next_rotation(String password_next_rotation) {
        this.password_next_rotation = password_next_rotation;
    }

    public String isMfa_active() {
        return mfa_active;
    }

    public void setMfa_active(String mfa_active) {
        this.mfa_active = mfa_active;
    }

    public String isAccess_key_1_active() {
        return access_key_1_active;
    }

    public void setAccess_key_1_active(String access_key_1_active) {
        this.access_key_1_active = access_key_1_active;
    }

    public String getAccess_key_1_last_rotated() {
        return access_key_1_last_rotated;
    }

    public void setAccess_key_1_last_rotated(String access_key_1_last_rotated) {
        this.access_key_1_last_rotated = access_key_1_last_rotated;
    }

    public String getAccess_key_1_last_used_date() {
        return access_key_1_last_used_date;
    }

    public void setAccess_key_1_last_used_date(String access_key_1_last_used_date) {
        this.access_key_1_last_used_date = access_key_1_last_used_date;
    }

    public String getAccess_key_1_last_used_region() {
        return access_key_1_last_used_region;
    }

    public void setAccess_key_1_last_used_region(String access_key_1_last_used_region) {
        this.access_key_1_last_used_region = access_key_1_last_used_region;
    }

    public String getAccess_key_1_last_used_service() {
        return access_key_1_last_used_service;
    }

    public void setAccess_key_1_last_used_service(String access_key_1_last_used_service) {
        this.access_key_1_last_used_service = access_key_1_last_used_service;
    }

    public String isAccess_key_2_active() {
        return access_key_2_active;
    }

    public void setAccess_key_2_active(String access_key_2_active) {
        this.access_key_2_active = access_key_2_active;
    }

    public String getAccess_key_2_last_rotated() {
        return access_key_2_last_rotated;
    }

    public void setAccess_key_2_last_rotated(String access_key_2_last_rotated) {
        this.access_key_2_last_rotated = access_key_2_last_rotated;
    }

    public String getAccess_key_2_last_used_date() {
        return access_key_2_last_used_date;
    }

    public void setAccess_key_2_last_used_date(String access_key_2_last_used_date) {
        this.access_key_2_last_used_date = access_key_2_last_used_date;
    }

    public String getAccess_key_2_last_used_region() {
        return access_key_2_last_used_region;
    }

    public void setAccess_key_2_last_used_region(String access_key_2_last_used_region) {
        this.access_key_2_last_used_region = access_key_2_last_used_region;
    }

    public String getAccess_key_2_last_used_service() {
        return access_key_2_last_used_service;
    }

    public void setAccess_key_2_last_used_service(String access_key_2_last_used_service) {
        this.access_key_2_last_used_service = access_key_2_last_used_service;
    }

    public String isCert_1_active() {
        return cert_1_active;
    }

    public void setCert_1_active(String cert_1_active) {
        this.cert_1_active = cert_1_active;
    }

    public String getCert_1_last_rotated() {
        return cert_1_last_rotated;
    }

    public void setCert_1_last_rotated(String cert_1_last_rotated) {
        this.cert_1_last_rotated = cert_1_last_rotated;
    }

    public String isCert_2_active() {
        return cert_2_active;
    }

    public void setCert_2_active(String cert_2_active) {
        this.cert_2_active = cert_2_active;
    }

    public String getCert_2_last_rotated() {
        return cert_2_last_rotated;
    }

    public void setCert_2_last_rotated(String cert_2_last_rotated) {
        this.cert_2_last_rotated = cert_2_last_rotated;
    }
}
