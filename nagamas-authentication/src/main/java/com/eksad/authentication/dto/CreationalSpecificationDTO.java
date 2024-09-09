package com.eksad.authentication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.Date;

@Embeddable
public class CreationalSpecificationDTO implements Serializable {

	@Column(name = "created_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Jakarta")
//	@JsonbDateFormat(value = "dd-MM-yyyy HH:mm:ss")
    private Date createdAt;

	@Column(name = "created_by")
    private String createdBy;

	@Column(name = "modified_at")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Asia/Jakarta")
//    @JsonbDateFormat(value = "dd-MM-yyyy HH:mm:ss")
    private Date modifiedAt;

	@Column(name = "modified_by")
    private String modifiedBy;

    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
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

    public CreationalSpecificationDTO() {
    }

    public CreationalSpecificationDTO(Date createdAt, String createdBy, Date modifiedAt, String modifiedBy) {
    	this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.modifiedAt = modifiedAt;
        this.modifiedBy = modifiedBy;
    }

}
