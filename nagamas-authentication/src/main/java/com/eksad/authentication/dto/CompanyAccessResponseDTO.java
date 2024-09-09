package com.eksad.authentication.dto;

import java.util.List;

public class CompanyAccessResponseDTO {
    private String userId;
    private List<CompanyAccess> companyAccess;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CompanyAccess> getCompanyAccess() {
        return companyAccess;
    }

    public void setCompanyAccess(List<CompanyAccess> companyAccess) {
        this.companyAccess = companyAccess;
    }
}
