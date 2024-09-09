package com.eksad.authentication.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "vw_dealer_unit_category", schema = "public")
public class ViewDealerUnitCategory  {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "dealer_id")
    private String dealerId;

    @Column(name = "dealer_name")
    private String dealerName;

    @Column(name = "dealer_vehicle_category_id")
    private String dealerVehicleCategoryId;

    @Column(name = "dealer_vehicle_category_name")
    private String dealerVehicleCategoryName;

    @Column(name = "dealer_vehicle_category_logo")
    private String dealerVehicleCategoryLogo;

    public String getDealerVehicleCategoryLogo() {
        return dealerVehicleCategoryLogo;
    }

    public Integer getId() {
        return id;
    }

    public String getDealerId() {
        return dealerId;
    }

    public String getDealerName() {
        return dealerName;
    }

    public String getDealerVehicleCategoryId() {
        return dealerVehicleCategoryId;
    }

    public String getDealerVehicleCategoryName() {
        return dealerVehicleCategoryName;
    }
}
