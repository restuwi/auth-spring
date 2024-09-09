package com.eksad.authentication.dto;

public class RequestFormItemDto {
    private String formId;

    public RequestFormItemDto(String formId) {
        this.formId = formId;
    }

    public RequestFormItemDto(){
        
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }
}
