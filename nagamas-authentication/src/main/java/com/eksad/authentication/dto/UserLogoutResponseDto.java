package com.eksad.authentication.dto;

public class UserLogoutResponseDto {
    private String idEmp;
    private Boolean result;

    public String getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(String idEmp) {
        this.idEmp = idEmp;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
