package com.eksad.authentication.dto;

public class UserLoginFullRequestDto {
    private String register;
    private String registerType;
    private String dealerGroupId;
    private String password;
    private String idDevice;
    private Double loginLocationLongitude;
    private Double loginLocationLatitude;
    private Boolean isRemember;

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getRegisterType() {
        return registerType;
    }

    public void setRegisterType(String registerType) {
        this.registerType = registerType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String idDevice) {
        this.idDevice = idDevice;
    }

    public Double getLoginLocationLongitude() {
        return loginLocationLongitude;
    }

    public void setLoginLocationLongitude(Double loginLocationLongitude) {
        this.loginLocationLongitude = loginLocationLongitude;
    }

    public Double getLoginLocationLatitude() {
        return loginLocationLatitude;
    }

    public void setLoginLocationLatitude(Double loginLocationLatitude) {
        this.loginLocationLatitude = loginLocationLatitude;
    }

    public Boolean getIsRemember() {
        return isRemember;
    }

    public void setIsRemember(Boolean remember) {
        isRemember = remember;
    }

    public String getDealerGroupId() {
        return dealerGroupId;
    }

    public void setDealerGroupId(String dealerGroupId) {
        this.dealerGroupId = dealerGroupId;
    }
}
