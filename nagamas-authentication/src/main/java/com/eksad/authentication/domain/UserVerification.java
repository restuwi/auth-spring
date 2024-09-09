package com.eksad.authentication.domain;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "user_verification", schema = "public")
public class UserVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_verification_id")
    private String userVerificationId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "dealer_group_id")
    private String dealerGroupId;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "csrf")
    private String csrf;

    @Column(name = "flag_send_mail")
    private String flagSendMail;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_dt")
    private Date modifiedDt;

    @Column(name = "modified_by")
    private String modifiedBy;

    public String getUserVerificationId() {
        return this.userVerificationId;
    }

    public void setUserVerificationId(String userVerificationId) {
        this.userVerificationId = userVerificationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDealerGroupId() {
        return dealerGroupId;
    }

    public void setDealerGroupId(String dealerGroupId) {
        this.dealerGroupId = dealerGroupId;
    }

    public String getVerificationCode() {
        return this.verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCsrf() {
        return this.csrf;
    }

    public void setCsrf(String csrf) {
        this.csrf = csrf;
    }

    public String getFlagSendMail() {
        return this.flagSendMail;
    }

    public void setFlagSendMail(String flagSendMail) {
        this.flagSendMail = flagSendMail;
    }

    public Date getCreatedDt() {
        return this.createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDt() {
        return this.modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
