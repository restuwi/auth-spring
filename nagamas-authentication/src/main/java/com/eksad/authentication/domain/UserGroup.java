package com.eksad.authentication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_group", schema = "public")
public class UserGroup  {
	
	@Id
    @Column(name = "user_group_id")
    private String userGroupId;
	
	@Column(name = "user_id")
    private String userId;
	
	@Column(name = "group_id")
    private String groupId;
	
	@Enumerated (EnumType.STRING)
    @Column(name = "status")
    private DataStatus status;
	
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(name = "modified_at")
    private Date modifiedAt;
    
    @Column(name = "modified_by")
    private String modifiedBy;

	public UserGroup() {
		
	}

	public UserGroup(String userGroupId, String userId, String groupId, DataStatus status, Date createdAt, String createdBy, Date modifiedAt, String modifiedBy) {
		this.userGroupId = userGroupId;
		this.userId = userId;
		this.groupId = groupId;
		this.status = status;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}

	public String getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(String userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public DataStatus getStatus() {
		return status;
	}

	public void setStatus(DataStatus status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedDate(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
    
}
