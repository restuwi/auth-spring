package com.eksad.authentication.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "vw_mst_role_access")
public class ViewMasterRoleAccess {

    @Id
    @Column(name = "group_id")
    private String groupId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "division_code")
    private String divisionCode;

    @Column(name = "kabkot_name")
    private String kabkotName;

    @Column(name = "status")
    private String status;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDivisionCode() {
        return this.divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getKabkotName() {
        return this.kabkotName;
    }

    public void setKabkotName(String kabkotName) {
        this.kabkotName = kabkotName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
