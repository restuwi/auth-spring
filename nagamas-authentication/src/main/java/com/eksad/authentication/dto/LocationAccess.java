package com.eksad.authentication.dto;

public class LocationAccess {
    private String roleId;
    private String userId;
    private String emplId;
    private String dataAllowedId;
    private String dataId;
    private String locationName;
    private String id;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    public String getDataAllowedId() {
        return dataAllowedId;
    }

    public void setDataAllowedId(String dataAllowedId) {
        this.dataAllowedId = dataAllowedId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
