package com.eksad.authentication.dto;

import java.util.List;

public class ButtonAccessResponseDto {
    private String userId;
    private String formId;
    private List<ButtonAccess> buttonAccess;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public List<ButtonAccess> getButtonAccess() {
        return buttonAccess;
    }

    public void setButtonAccess(List<ButtonAccess> buttonAccess) {
        this.buttonAccess = buttonAccess;
    }
}
