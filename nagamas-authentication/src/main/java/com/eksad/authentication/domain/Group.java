package com.eksad.authentication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "group", schema = "public")
public class Group {

	@Id
    @Column(name = "group_id")
    private String groupId;
	
	@Column(name = "group_name")
	private String groupName;
	
	@Column(name = "group_description")
	private String groupDescription;
	
	@Column(name = "dealer_group_id")
	private String dealerGroupId;
	
	@Column(name = "dealer_id")
	private String dealerId;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "group_start_date")
    private Date groupStartDate;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "group_end_date")
    private Date groupEndDate;
	
	@Enumerated (EnumType.STRING)
    @Column(name = "status")
    private DataStatus status;
	
	@Column(name = "is_global")
    private Boolean isGlobal;
	
	@Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(name = "created_date")
    private Date createdDate;
    
    @Column(name = "created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Column(name = "modified_date")
    private Date modifiedDate;
    
    @Column(name = "modified_by")
    private String modifiedBy;

	public Group() {
		
	}

	public Group(String groupId, String groupName, String groupDescription, String dealerGroupId, String dealerId, Date groupStartDate, Date groupEndDate, DataStatus status, Boolean isGlobal, Date createdDate, String createdBy, Date modifiedDate, String modifiedBy) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.dealerGroupId = dealerGroupId;
		this.dealerId = dealerId;
		this.groupStartDate = groupStartDate;
		this.groupEndDate = groupEndDate;
		this.status = status;
		this.isGlobal = isGlobal;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedDate = modifiedDate;
		this.modifiedBy = modifiedBy;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}

	public String getDealerGroupId() {
		return dealerGroupId;
	}

	public void setDealerGroupId(String dealerGroupId) {
		this.dealerGroupId = dealerGroupId;
	}

	public String getDealerId() {
		return dealerId;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public Date getGroupStartDate() {
		return groupStartDate;
	}

	public void setGroupStartDate(Date groupStartDate) {
		this.groupStartDate = groupStartDate;
	}

	public Date getGroupEndDate() {
		return groupEndDate;
	}

	public void setGroupEndDate(Date groupEndDate) {
		this.groupEndDate = groupEndDate;
	}

	public DataStatus getStatus() {
		return status;
	}

	public void setStatus(DataStatus status) {
		this.status = status;
	}

	public Boolean getIsGlobal() {
		return isGlobal;
	}

	public void setIsGlobal(Boolean isGlobal) {
		this.isGlobal = isGlobal;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
    
}
