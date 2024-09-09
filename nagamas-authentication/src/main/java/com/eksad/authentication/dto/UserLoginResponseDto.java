package com.eksad.authentication.dto;

public class UserLoginResponseDto {
    private String idEmp;
    private String jwtToken;
    private String name;
    private Long idUser;
    private Boolean result;
    private String userCategory;
    private Integer passwordExpired;
    private String sessionId;

    public String getIdEmp(String employeeId) {
        return idEmp;
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

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdUser(Long idUser) {
        return this.idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    public Long getIdUser() {
        return this.idUser;
    }
}
