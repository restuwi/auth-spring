package com.eksad.authentication.domain;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "user_login_not_found", schema = "public")
public class UserLoginNotFound{

    @Id
    @GenericGenerator(name = "user_login_log_not_found_id", type = com.eksad.authentication.domain.generator.IdGenerator.class)
    @GeneratedValue(generator = "user_login_log_not_found_id")
    @Column(name = "id_user_login_not_found")
    private String idUserLoginNotFound;

    @Column(name = "username")
    private String username;

    @Column(name = "message")
    private String message;

    @Column(name = "dealer_group_id")
    private String dealerGroupId;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "created_by")
    private String createdBy;

    public String getIdUserLoginNotFound() {
        return idUserLoginNotFound;
    }

    public void setIdUserLoginNotFound(String idUserLoginNotFound) {
        this.idUserLoginNotFound = idUserLoginNotFound;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDealerGroupId() {
        return dealerGroupId;
    }

    public void setDealerGroupId(String dealerGroupId) {
        this.dealerGroupId = dealerGroupId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
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
}
