package com.eksad.authentication.dto;

import com.eksad.authentication.domain.ViewUserAuthorization;

import java.util.List;

/**
 * @author rey on 21/06/22
 */
public class UserLoginFullAccessResponseDTO {
    private String idEmp;
    private String jwtToken;
    private String name;
    private Long idUser;
    private Boolean result;
    private String userCategory;
    private Integer passwordExpired;
    private String sessionId;

    private String dealerId;

    private String dealerName;
    private List<ViewUserAuthorization> authorizations;

    private List<UserUnitCategoryDTO> unitCategory;

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    public List<UserUnitCategoryDTO> getUnitCategory() {
        return unitCategory;
    }

    public void setUnitCategory(List<UserUnitCategoryDTO> unitCategory) {
        this.unitCategory = unitCategory;
    }



    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public Integer getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Integer passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<ViewUserAuthorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(List<ViewUserAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

//    public List<ViewUserAuthorization> getAuthorizations() {
//        return authorizations;
//    }
//
//    public void setAuthorizations(List<ViewUserAuthorization> authorizations) {
//        this.authorizations = authorizations;
//    }
}
