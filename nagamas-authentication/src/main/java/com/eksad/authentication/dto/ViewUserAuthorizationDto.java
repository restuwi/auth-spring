package com.eksad.authentication.dto;

public class ViewUserAuthorizationDto {
    private String authID;
    private String userID;
    private String groupID;
    private String groupName;
    private String menuID;
    private String menuName;
    private Boolean readAccess;
    private Boolean writeAccess;
    private Boolean deleteAccess;
    private Boolean editAccess;


    public ViewUserAuthorizationDto(String authID, String userID, String groupID, String groupName, String menuID, String menuName, Boolean readAccess, Boolean writeAccess, Boolean deleteAccess, Boolean editAccess) {
        this.authID = authID;
        this.userID = userID;
        this.groupID = groupID;
        this.groupName = groupName;
        this.menuID = menuID;
        this.menuName = menuName;
        this.readAccess = readAccess;
        this.writeAccess = writeAccess;
        this.deleteAccess = deleteAccess;
        this.editAccess = editAccess;
    }


    public String getAuthID() {
        return authID;
    }



    public void setAuthID(String authID) {
        this.authID = authID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMenuID() {
        return menuID;
    }

    public void setMenuID(String menuID) {
        this.menuID = menuID;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Boolean getReadAccess() {
        return readAccess;
    }

    public void setReadAccess(Boolean readAccess) {
        this.readAccess = readAccess;
    }

    public Boolean getWriteAccess() {
        return writeAccess;
    }

    public void setWriteAccess(Boolean writeAccess) {
        this.writeAccess = writeAccess;
    }

    public Boolean getDeleteAccess() {
        return deleteAccess;
    }

    public void setDeleteAccess(Boolean deleteAccess) {
        this.deleteAccess = deleteAccess;
    }

    public Boolean getEditAccess() {
        return editAccess;
    }

    public void setEditAccess(Boolean editAccess) {
        this.editAccess = editAccess;
    }
}
