package com.eksad.authentication.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "vw_mst_access_form", schema = "public")
public class ViewMasterAccessForm  {

    @Id
    @Column(name = "auth_id")
    private String authId;

    @Column(name = "group_id")
    private String groupId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "empl_id")
    private String emplId;

    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "form_id")
    private String formId;

    @Column(name = "description")
    private String description;

    @Column(name = "read_access")
    private Boolean readAccess;

    @Column(name = "write_access")
    private Boolean writeAccess;

    @Column(name = "delete_access")
    private Boolean deleteAccess;

    @Column(name = "edit_access")
    private Boolean editAccess;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmplId() {
        return this.emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getFormId() {
        return this.formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
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
