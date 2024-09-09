package com.eksad.authentication.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "mst_dealer_group", schema = "public")
public class MasterDealerGroup {
    @Id
    @Column(name = "dealer_group_id")
    private String dealerGroupId;

    @Column(name = "dealer_group_code")
    private String dealerGroupCode;

    @Column(name = "dealer_group_name")
    private String dealerGroupName;

    @Column(name = "is_encrypted")
    private String isEncrypted;

    public String getDealerGroupId() {
        return dealerGroupId;
    }

    public void setDealerGroupId(String dealerGroupId) {
        this.dealerGroupId = dealerGroupId;
    }

    public String getDealerGroupCode() {
        return dealerGroupCode;
    }

    public void setDealerGroupCode(String dealerGroupCode) {
        this.dealerGroupCode = dealerGroupCode;
    }

    public String getDealerGroupName() {
        return dealerGroupName;
    }

    public void setDealerGroupName(String dealerGroupName) {
        this.dealerGroupName = dealerGroupName;
    }

    public String getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(String isEncrypted) {
        this.isEncrypted = isEncrypted;
    }
}
