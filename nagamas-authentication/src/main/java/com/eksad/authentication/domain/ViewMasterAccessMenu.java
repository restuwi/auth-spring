package com.eksad.authentication.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "vw_mst_access_menu", schema = "public")
public class ViewMasterAccessMenu {

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

    @Column(name = "description")
    private String description;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
