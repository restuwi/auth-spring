package com.eksad.authentication.domain;


import jakarta.persistence.*;

/**
 * @author rey on 21/06/22
 */
@Entity
@Table(name = "vw_user_authorization", schema = "public")
public class ViewUserAuthorization{
    @Id
    @Column(name = "auth_id")
    private String authID;

    @Column(name = "user_id")
    private String userID;

    @Column(name = "group_id")
    private String groupID;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "menu_id")
    private String menuID;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "read_access")
    private Boolean readAccess;

    @Column(name = "write_access")
    private Boolean writeAccess;

    @Column(name = "delete_access")
    private Boolean deleteAccess;

    @Column(name = "edit_access")
    private Boolean editAccess;

    public ViewUserAuthorization(String authID, String userID, String groupID, String groupName, String menuID, String menuName, Boolean readAccess, Boolean writeAccess, Boolean deleteAccess, Boolean editAccess) {
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

    public ViewUserAuthorization() {

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
