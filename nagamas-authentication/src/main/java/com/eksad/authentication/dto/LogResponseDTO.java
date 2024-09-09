package com.eksad.authentication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LogResponseDTO {

    private String domain;
    private String domainEvent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date timeEvent;
    private String eventOpsStatus;
    private String eventOpsHttp;
    private Object data;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomainEvent() {
        return domainEvent;
    }

    public void setDomainEvent(String domainEvent) {
        this.domainEvent = domainEvent;
    }

    public Date getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(Date timeEvent) {
        this.timeEvent = timeEvent;
    }

    public String getEventOpsStatus() {
        return eventOpsStatus;
    }

    public void setEventOpsStatus(String eventOpsStatus) {
        this.eventOpsStatus = eventOpsStatus;
    }

    public String getEventOpsHttp() {
        return eventOpsHttp;
    }

    public void setEventOpsHttp(String eventOpsHttp) {
        this.eventOpsHttp = eventOpsHttp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LogResponseDTO() {
    }

    public LogResponseDTO(String domain, String domainEvent, Date timeEvent, String eventOpsStatus, String eventOpsHttp, Object data) {
        this.domain = domain;
        this.domainEvent = domainEvent;
        this.timeEvent = timeEvent;
        this.eventOpsStatus = eventOpsStatus;
        this.eventOpsHttp = eventOpsHttp;
        this.data = data;
    }
}
