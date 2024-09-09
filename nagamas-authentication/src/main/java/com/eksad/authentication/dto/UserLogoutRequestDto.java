package com.eksad.authentication.dto;

public class UserLogoutRequestDto {
    private Double logoutLocationLongitude;
    private Double logoutLocationLatitude;

    public Double getLogoutLocationLongitude() {
        return logoutLocationLongitude;
    }

    public void setLogoutLocationLongitude(Double logoutLocationLongitude) {
        this.logoutLocationLongitude = logoutLocationLongitude;
    }

    public Double getLogoutLocationLatitude() {
        return logoutLocationLatitude;
    }

    public void setLogoutLocationLatitude(Double logoutLocationLatitude) {
        this.logoutLocationLatitude = logoutLocationLatitude;
    }
}
