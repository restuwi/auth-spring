package com.eksad.authentication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "authorization", schema = "public")
public class Authorization  {
	
    @Id
    @Column(name = "auth_id")
    private String authId;

    @Column(name = "object_type_id")
    private String objectTypeId;

    @Column(name = "object_id")
    private String objectId;

    @Column(name = "user_or_group_id")
    private String userOrGroupId;

    @Column(name = "is_group")
    private Boolean isGroup;
    
    @Column(name = "read_access")
    private Boolean readAccess;
    
    @Column(name = "write_access")
    private Boolean writeAccess;
    
    @Column(name = "delete_access")
    private Boolean deleteAccess;
    
    @Column(name = "edit_access")
    private Boolean editAccess;
    
    @Column(name = "deny_read_access")
    private Boolean denyReadAccess;
    
    @Column(name = "deny_write_access")
    private Boolean denyWriteAccess;
    
    @Column(name = "deny_edit_access")
    private Boolean denyEditAccess;
    
    @Column(name = "deny_delete_access")
    private Boolean denyDeleteAccess;
    
    @Enumerated (EnumType.STRING)
    @Column(name = "status")
    private DataStatus authorizationStatus;

    @Column(name = "created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(name = "modified_date")
    private Date modifiedDate;

	public Authorization() {
		super();
	}

	public Authorization(String authId, String objectTypeId, String objectId, String userOrGroupId, Boolean isGroup, Boolean readAccess, Boolean writeAccess, Boolean deleteAccess, Boolean editAccess, Boolean denyReadAccess, Boolean denyWriteAccess, Boolean denyEditAccess, Boolean denyDeleteAccess, DataStatus authorizationStatus, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
		this.authId = authId;
		this.objectTypeId = objectTypeId;
		this.objectId = objectId;
		this.userOrGroupId = userOrGroupId;
		this.isGroup = isGroup;
		this.readAccess = readAccess;
		this.writeAccess = writeAccess;
		this.deleteAccess = deleteAccess;
		this.editAccess = editAccess;
		this.denyReadAccess = denyReadAccess;
		this.denyWriteAccess = denyWriteAccess;
		this.denyEditAccess = denyEditAccess;
		this.denyDeleteAccess = denyDeleteAccess;
		this.authorizationStatus = authorizationStatus;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getObjectTypeId() {
		return objectTypeId;
	}

	public void setObjectTypeId(String objectTypeId) {
		this.objectTypeId = objectTypeId;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getUserOrGroupId() {
		return userOrGroupId;
	}

	public void setUserOrGroupId(String userOrGroupId) {
		this.userOrGroupId = userOrGroupId;
	}

	public Boolean getIsGroup() {
		return isGroup;
	}

	public void setIsGroup(Boolean isGroup) {
		this.isGroup = isGroup;
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

	public Boolean getDenyReadAccess() {
		return denyReadAccess;
	}

	public void setDenyReadAccess(Boolean denyReadAccess) {
		this.denyReadAccess = denyReadAccess;
	}

	public Boolean getDenyWriteAccess() {
		return denyWriteAccess;
	}

	public void setDenyWriteAccess(Boolean denyWriteAccess) {
		this.denyWriteAccess = denyWriteAccess;
	}

	public Boolean getDenyEditAccess() {
		return denyEditAccess;
	}

	public void setDenyEditAccess(Boolean denyEditAccess) {
		this.denyEditAccess = denyEditAccess;
	}

	public Boolean getDenyDeleteAccess() {
		return denyDeleteAccess;
	}

	public void setDenyDeleteAccess(Boolean denyDeleteAccess) {
		this.denyDeleteAccess = denyDeleteAccess;
	}

	public DataStatus getAuthorizationStatus() {
		return authorizationStatus;
	}

	public void setAuthorizationStatus(DataStatus authorizationStatus) {
		this.authorizationStatus = authorizationStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
