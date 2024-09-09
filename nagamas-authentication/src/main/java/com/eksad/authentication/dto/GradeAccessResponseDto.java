package com.eksad.authentication.dto;

import java.util.List;

public class GradeAccessResponseDto {
    private String userId;
    private List<GradeAccess> gradeAccess;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<GradeAccess> getGradeAccess() {
        return gradeAccess;
    }

    public void setGradeAccess(List<GradeAccess> gradeAccess) {
        this.gradeAccess = gradeAccess;
    }
}
