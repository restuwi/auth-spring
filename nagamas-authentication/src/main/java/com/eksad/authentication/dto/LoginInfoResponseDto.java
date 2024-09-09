package com.eksad.authentication.dto;

public class LoginInfoResponseDto {
    private String username;
    private Long userId;
    private String empId;
    private String dealerId;
    private String dealerGroupId;
    private Boolean isRemember;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public String getDealerGroupId() {
        return dealerGroupId;
    }

    public void setDealerGroupId(String dealerGroupId) {
        this.dealerGroupId = dealerGroupId;
    }

    public Boolean getRemember() {
        return isRemember;
    }

    public void setRemember(Boolean remember) {
        isRemember = remember;
    }

    public Boolean getIsRemember() {
        return isRemember;
    }

    public void setIsRemember(Boolean remember) {
        isRemember = remember;
    }
}
