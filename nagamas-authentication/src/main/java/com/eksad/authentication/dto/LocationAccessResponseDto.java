package com.eksad.authentication.dto;

import java.util.List;

public class LocationAccessResponseDto {
    private String userId;
    private List<LocationAccess> locationAccess;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<LocationAccess> getLocationAccess() {
        return locationAccess;
    }

    public void setLocationAccess(List<LocationAccess> locationAccess) {
        this.locationAccess = locationAccess;
    }
}
