package com.eksad.authentication.dto;

import java.util.List;

public class FormAccessResponseDto {
    private String userId;
    private List<CompanyAccess> companyAccess;
    private List<LocationAccess> locationAccess;
    private List<GradeAccess> gradeAccess;

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

    public List<LocationAccess> getLocationAccess() {
        return locationAccess;
    }

    public void setLocationAccess(List<LocationAccess> locationAccess) {
        this.locationAccess = locationAccess;
    }

    public List<GradeAccess> getGradeAccess() {
        return gradeAccess;
    }

    public void setGradeAccess(List<GradeAccess> gradeAccess) {
        this.gradeAccess = gradeAccess;
    }
}
