package com.eksad.authentication.domain;

public enum DataStatus {

        ACTIVE("Active"),
        INACTIVE("Inactive");

        private String status;

        DataStatus(String status) {
            this.status = status;
        }

}
