package com.eksad.authentication.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LogOpsDTO {

    private String domain;
    private String domainEvent;
    private String domainClass;
    private String domainParty;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+7")
    private Date timeEvent;
    private String eventType;
    private String eventOps;
    private String user;
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

    public String getDomainClass() {
        return domainClass;
    }

    public void setDomainClass(String domainClass) {
        this.domainClass = domainClass;
    }

    public String getDomainParty() {
        return domainParty;
    }

    public void setDomainParty(String domainParty) {
        this.domainParty = domainParty;
    }

    public Date getTimeEvent() {
        return timeEvent;
    }

    public void setTimeEvent(Date timeEvent) {
        this.timeEvent = timeEvent;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventOps() {
        return eventOps;
    }

    public void setEventOps(String eventOps) {
        this.eventOps = eventOps;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public LogOpsDTO(String domain, String domainEvent, String domainClass, String domainParty, Date timeEvent, String eventType, String eventOps, String user, Object data) {
        this.domain = domain;
        this.domainEvent = domainEvent;
        this.domainClass = domainClass;
        this.domainParty = domainParty;
        this.timeEvent = timeEvent;
        this.eventType = eventType;
        this.eventOps = eventOps;
        this.user = user;
        this.data = data;
    }

    public LogOpsDTO() {
    }
}
