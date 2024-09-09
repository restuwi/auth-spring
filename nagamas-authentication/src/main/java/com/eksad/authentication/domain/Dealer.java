package com.eksad.authentication.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mst_dealer", schema = "public")
public class Dealer  {
    @Id
    @Column(name = "dealer_id")
    private String dealerId;

    @Column(name = "dealer_group_id")
    private String dealerGroupId;

    @Column(name = "dealer_name")
    private String dealerName;

    @Column(name = "dealer_npwp")
    private String dealerNpwp;

    @Column(name = "dealer_email")
    private String dealerEmail;

    @Column(name = "dealer_description")
    private String dealerDescription;

    @Column(name = "dealer_tel_number")
    private String dealerTelNumber;

    @Column(name = "dealer_phone_number")
    private String dealerPhoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "country_id")
    private String countryId;

    @Column(name = "province_id")
    private String provinceId;

    @Column(name = "kabkot_id")
    private String kabkotId;

    @Column(name = "kecamatan_id")
    private String kecamatanId;

    @Column(name = "kelurahan_id")
    private String kelurahanId;

    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "dealer_pic_name")
    private String dealerPICName;

    @Column(name = "dealer_pic_identity_number")
    private String dealerPICIdentityNumber;

    @Column(name = "logo")
    private String logo;

    @Column(name = "is_lock")
    private Integer isLock;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "gps_latitude")
    private double gpsLatitude;

    @Column(name = "gps_longitude")
    private double gpsLongitude;

    @Column(name = "registration_date")
    private Date dealerRegistrationDate;

    @Column(name = "dealer_suspended_reason")
    private String dealerSuspendedReason;

    @Column(name = "dealer_status")
    private String dealerStatus;

    @Column(name = "subscribe_type_id")
    private String subscribeTypeId;

    @Column(name = "dealer_taxpayer_name")
    private String dealerTaxpayerName;

    @Column(name = "dealer_tax_status")
    private String dealerTaxStatus;

    @Column(name = "dealer_npwp_date")
    @Temporal(TemporalType.DATE)
    private Date dealerNPWPDate;

    @Column(name = "dealer_sppkp")
    private String dealerSPPKP;

    @Column(name = "dealer_sppkp_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date dealerSPPKPDate;

    @Column(name = "dealer_vehicle_category")
    private String dealerVheicleCategory;
    
    @Column(name = "dealer_brand_name")
    private String dealerBrandName;
    
    @Column(name = "dealer_ownership_type")
    private String dealerOwnershipType;
    
    @Column(name = "dealer_business_entity_type")
    private String dealerBusinessEntityType;
    
    @Column(name = "dealer_business_entity_others")
    private String dealerBusinessEntityOthers;
    
    @Column(name = "dealer_branch_type")
    private String dealerBranchType;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private DataStatus status;

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

	public Dealer() {

	}

	public Dealer(String dealerId, String dealerGroupId, String dealerName, String dealerNpwp, String dealerEmail, String dealerDescription, String dealerTelNumber, String dealerPhoneNumber, String address, String countryId, String provinceId, String kabkotId, String kecamatanId, String kelurahanId, String zipcode, String dealerPICName, String dealerPICIdentityNumber, String logo, Integer isLock, String ownerName, double gpsLatitude, double gpsLongitude, Date dealerRegistrationDate, String dealerSuspendedReason, String dealerStatus, String subscribeTypeId, String dealerTaxpayerName, String dealerTaxStatus, Date dealerNPWPDate, String dealerSPPKP, Date dealerSPPKPDate, String dealerVheicleCategory, String dealerBrandName, String dealerOwnershipType, String dealerBusinessEntityType, String dealerBusinessEntityOthers, String dealerBranchType, DataStatus status, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
		this.dealerId = dealerId;
		this.dealerGroupId = dealerGroupId;
		this.dealerName = dealerName;
		this.dealerNpwp = dealerNpwp;
		this.dealerEmail = dealerEmail;
		this.dealerDescription = dealerDescription;
		this.dealerTelNumber = dealerTelNumber;
		this.dealerPhoneNumber = dealerPhoneNumber;
		this.address = address;
		this.countryId = countryId;
		this.provinceId = provinceId;
		this.kabkotId = kabkotId;
		this.kecamatanId = kecamatanId;
		this.kelurahanId = kelurahanId;
		this.zipcode = zipcode;
		this.dealerPICName = dealerPICName;
		this.dealerPICIdentityNumber = dealerPICIdentityNumber;
		this.logo = logo;
		this.isLock = isLock;
		this.ownerName = ownerName;
		this.gpsLatitude = gpsLatitude;
		this.gpsLongitude = gpsLongitude;
		this.dealerRegistrationDate = dealerRegistrationDate;
		this.dealerSuspendedReason = dealerSuspendedReason;
		this.dealerStatus = dealerStatus;
		this.subscribeTypeId = subscribeTypeId;
		this.dealerTaxpayerName = dealerTaxpayerName;
		this.dealerTaxStatus = dealerTaxStatus;
		this.dealerNPWPDate = dealerNPWPDate;
		this.dealerSPPKP = dealerSPPKP;
		this.dealerSPPKPDate = dealerSPPKPDate;
		this.dealerVheicleCategory = dealerVheicleCategory;
		this.dealerBrandName = dealerBrandName;
		this.dealerOwnershipType = dealerOwnershipType;
		this.dealerBusinessEntityType = dealerBusinessEntityType;
		this.dealerBusinessEntityOthers = dealerBusinessEntityOthers;
		this.dealerBranchType = dealerBranchType;
		this.status = status;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
	}

	public String getDealerId() {
		return dealerId;
	}

	public String getDealerGroupId() {
		return dealerGroupId;
	}

	public String getDealerName() {
		return dealerName;
	}

	public String getDealerNpwp() {
		return dealerNpwp;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public String getDealerDescription() {
		return dealerDescription;
	}

	public String getDealerTelNumber() {
		return dealerTelNumber;
	}

	public String getDealerPhoneNumber() {
		return dealerPhoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getCountryId() {
		return countryId;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public String getKabkotId() {
		return kabkotId;
	}

	public String getKecamatanId() {
		return kecamatanId;
	}

	public String getKelurahanId() {
		return kelurahanId;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getDealerPICName() {
		return dealerPICName;
	}

	public String getDealerPICIdentityNumber() {
		return dealerPICIdentityNumber;
	}

	public String getLogo() {
		return logo;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getGpsLatitude() {
		return gpsLatitude;
	}

	public double getGpsLongitude() {
		return gpsLongitude;
	}

	public Date getDealerRegistrationDate() {
		return dealerRegistrationDate;
	}

	public String getDealerSuspendedReason() {
		return dealerSuspendedReason;
	}

	public String getDealerStatus() {
		return dealerStatus;
	}

	public String getSubscribeTypeId() {
		return subscribeTypeId;
	}

	public String getDealerTaxpayerName() {
		return dealerTaxpayerName;
	}

	public String getDealerTaxStatus() {
		return dealerTaxStatus;
	}

	public Date getDealerNPWPDate() {
		return dealerNPWPDate;
	}

	public String getDealerSPPKP() {
		return dealerSPPKP;
	}

	public Date getDealerSPPKPDate() {
		return dealerSPPKPDate;
	}

	public String getDealerVheicleCategory() {
		return dealerVheicleCategory;
	}

	public String getDealerBrandName() {
		return dealerBrandName;
	}

	public String getDealerOwnershipType() {
		return dealerOwnershipType;
	}

	public String getDealerBusinessEntityType() {
		return dealerBusinessEntityType;
	}

	public String getDealerBusinessEntityOthers() {
		return dealerBusinessEntityOthers;
	}

	public String getDealerBranchType() {
		return dealerBranchType;
	}

	public DataStatus getStatus() {
		return status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}

	public void setDealerGroupId(String dealerGroupId) {
		this.dealerGroupId = dealerGroupId;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public void setDealerNpwp(String dealerNpwp) {
		this.dealerNpwp = dealerNpwp;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public void setDealerDescription(String dealerDescription) {
		this.dealerDescription = dealerDescription;
	}

	public void setDealerTelNumber(String dealerTelNumber) {
		this.dealerTelNumber = dealerTelNumber;
	}

	public void setDealerPhoneNumber(String dealerPhoneNumber) {
		this.dealerPhoneNumber = dealerPhoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public void setKabkotId(String kabkotId) {
		this.kabkotId = kabkotId;
	}

	public void setKecamatanId(String kecamatanId) {
		this.kecamatanId = kecamatanId;
	}

	public void setKelurahanId(String kelurahanId) {
		this.kelurahanId = kelurahanId;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setDealerPICName(String dealerPICName) {
		this.dealerPICName = dealerPICName;
	}

	public void setDealerPICIdentityNumber(String dealerPICIdentityNumber) {
		this.dealerPICIdentityNumber = dealerPICIdentityNumber;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setGpsLatitude(double gpsLatitude) {
		this.gpsLatitude = gpsLatitude;
	}

	public void setGpsLongitude(double gpsLongitude) {
		this.gpsLongitude = gpsLongitude;
	}

	public void setDealerRegistrationDate(Date dealerRegistrationDate) {
		this.dealerRegistrationDate = dealerRegistrationDate;
	}

	public void setDealerSuspendedReason(String dealerSuspendedReason) {
		this.dealerSuspendedReason = dealerSuspendedReason;
	}

	public void setDealerStatus(String dealerStatus) {
		this.dealerStatus = dealerStatus;
	}

	public void setSubscribeTypeId(String subscribeTypeId) {
		this.subscribeTypeId = subscribeTypeId;
	}

	public void setDealerTaxpayerName(String dealerTaxpayerName) {
		this.dealerTaxpayerName = dealerTaxpayerName;
	}

	public void setDealerTaxStatus(String dealerTaxStatus) {
		this.dealerTaxStatus = dealerTaxStatus;
	}

	public void setDealerNPWPDate(Date dealerNPWPDate) {
		this.dealerNPWPDate = dealerNPWPDate;
	}

	public void setDealerSPPKP(String dealerSPPKP) {
		this.dealerSPPKP = dealerSPPKP;
	}

	public void setDealerSPPKPDate(Date dealerSPPKPDate) {
		this.dealerSPPKPDate = dealerSPPKPDate;
	}

	public void setDealerVheicleCategory(String dealerVheicleCategory) {
		this.dealerVheicleCategory = dealerVheicleCategory;
	}

	public void setDealerBrandName(String dealerBrandName) {
		this.dealerBrandName = dealerBrandName;
	}

	public void setDealerOwnershipType(String dealerOwnershipType) {
		this.dealerOwnershipType = dealerOwnershipType;
	}

	public void setDealerBusinessEntityType(String dealerBusinessEntityType) {
		this.dealerBusinessEntityType = dealerBusinessEntityType;
	}

	public void setDealerBusinessEntityOthers(String dealerBusinessEntityOthers) {
		this.dealerBusinessEntityOthers = dealerBusinessEntityOthers;
	}

	public void setDealerBranchType(String dealerBranchType) {
		this.dealerBranchType = dealerBranchType;
	}

	public void setStatus(DataStatus status) {
		this.status = status;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
