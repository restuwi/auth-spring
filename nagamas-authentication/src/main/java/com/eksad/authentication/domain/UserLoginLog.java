package com.eksad.authentication.domain;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "user_login_log", schema = "public")
public class UserLoginLog {
    @Id
    @GenericGenerator(name = "user_login_log_id", type = com.eksad.authentication.domain.generator.IdGenerator.class)
    @GeneratedValue(generator = "user_login_log_id")
    @Column(name = "id_user_login_log")
    private String idUserLoginLog;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "id_device")
    private String idDevice;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "login_longitude")
    private Double loginLongitude;

    @Column(name = "login_latitude")
    private Double loginLatitude;

    @Column(name = "logout_time")
    private Date logoutTime;

    @Column(name = "logout_longitude")
    private Double logoutLongitude;

    @Column(name = "logout_latitude")
    private Double logoutLatitude;

    @Column(name = "notif_token")
    private String notifToken;

    @Column(name = "status_log")
    private String statusLog;

    @Column(name = "is_active")
    private Long isActive;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_dt")
    private Date modifiedDt;

    @Column(name = "modified_by")
    private String modifiedBy;

    public String getIdUserLoginLog() {
        return idUserLoginLog;
    }

    public void setIdUserLoginLog(String idUserLoginLog) {
        this.idUserLoginLog = idUserLoginLog;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String idDevice) {
        this.idDevice = idDevice;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Double getLoginLongitude() {
        return loginLongitude;
    }

    public void setLoginLongitude(Double loginLongitude) {
        this.loginLongitude = loginLongitude;
    }

    public Double getLoginLatitude() {
        return loginLatitude;
    }

    public void setLoginLatitude(Double loginLatitude) {
        this.loginLatitude = loginLatitude;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Double getLogoutLongitude() {
        return logoutLongitude;
    }

    public void setLogoutLongitude(Double logoutLongitude) {
        this.logoutLongitude = logoutLongitude;
    }

    public Double getLogoutLatitude() {
        return logoutLatitude;
    }

    public void setLogoutLatitude(Double logoutLatitude) {
        this.logoutLatitude = logoutLatitude;
    }

    public String getNotifToken() {
        return notifToken;
    }

    public void setNotifToken(String notifToken) {
        this.notifToken = notifToken;
    }

    public String getStatusLog() {
        return statusLog;
    }

    public void setStatusLog(String statusLog) {
        this.statusLog = statusLog;
    }

    public Long getIsActive() {
        return isActive;
    }

    public void setIsActive(Long isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
