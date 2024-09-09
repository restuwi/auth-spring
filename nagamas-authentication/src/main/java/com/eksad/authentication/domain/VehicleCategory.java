package com.eksad.authentication.domain;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_vehicle_category", schema = "public")
public class VehicleCategory {
    
	@Id
    @Column(name = "vehicle_category_id")
    private String vehicleCategoryId;

    @Column(name = "vehicle_category_name")
    private String vehicleCategoryName;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DataStatus status;

    @Column(name = "created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    private Date modifiedDate;

	public VehicleCategory() {
		
	}

	public VehicleCategory(String vehicleCategoryId, String vehicleCategoryName, DataStatus status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
		this.vehicleCategoryId = vehicleCategoryId;
		this.vehicleCategoryName = vehicleCategoryName;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public String getVehicleCategoryId() {
		return vehicleCategoryId;
	}

	public void setVehicleCategoryId(String vehicleCategoryId) {
		this.vehicleCategoryId = vehicleCategoryId;
	}

	public String getVehicleCategoryName() {
		return vehicleCategoryName;
	}

	public void setVehicleCategoryName(String vehicleCategoryName) {
		this.vehicleCategoryName = vehicleCategoryName;
	}

	public DataStatus getStatus() {
		return status;
	}

	public void setStatus(DataStatus status) {
		this.status = status;
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
