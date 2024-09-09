package com.eksad.authentication.dto;

/**
 * @author rey on 20/08/22
 */
public class UserUnitCategoryDTO {
    private String dealerVehicleCategoryId;
    private String dealerVehicleCategoryName;
    private String dealerVehicleCategoryLogo;

    public UserUnitCategoryDTO(String dealerVehicleCategoryId, String dealerVehicleCategoryName, String dealerVehicleCategoryLogo) {
        this.dealerVehicleCategoryId = dealerVehicleCategoryId;
        this.dealerVehicleCategoryName = dealerVehicleCategoryName;
        this.dealerVehicleCategoryLogo = dealerVehicleCategoryLogo;
    }

    public UserUnitCategoryDTO(){

    }

    public String getDealerVehicleCategoryId() {
        return dealerVehicleCategoryId;
    }

    public void setDealerVehicleCategoryId(String dealerVehicleCategoryId) {
        this.dealerVehicleCategoryId = dealerVehicleCategoryId;
    }

    public String getDealerVehicleCategoryName() {
        return dealerVehicleCategoryName;
    }

    public void setDealerVehicleCategoryName(String dealerVehicleCategoryName) {
        this.dealerVehicleCategoryName = dealerVehicleCategoryName;
    }

    public String getDealerVehicleCategoryLogo() {
        return dealerVehicleCategoryLogo;
    }

    public void setDealerVehicleCategoryLogo(String dealerVehicleCategoryLogo) {
        this.dealerVehicleCategoryLogo = dealerVehicleCategoryLogo;
    }
}
