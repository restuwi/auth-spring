package com.eksad.authentication.dto;


import java.util.List;

public class UserLoginFullResponseDto {
    private String idEmp;
    private String jwtToken;
    private String name;
    private Long idUser;
    private Boolean result;
    private String userCategory;
    private Integer passwordExpired;
    private String sessionId;
    private List<MenuAccessResponseDto> listMenu;

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

    public List<MenuAccessResponseDto> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<MenuAccessResponseDto> listMenu) {
        this.listMenu = listMenu;
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
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
