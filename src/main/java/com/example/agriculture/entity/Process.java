package com.example.agriculture.entity;

import java.util.Date;

/**
 * 加工商
 */
public class Process {
    private static final long serialVersionUID = 1L;

    private int processId;
    private int processUserId;
    private String processOnlyKey;
    private String factoryName;
    private String qualityInspector;//质检人员
    private String processPerson;//加工人员
    private Date date;//加工时间

    public String getProcessOnlyKey() {
        return processOnlyKey;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public void setProcessOnlyKey(String processOnlyKey) {
        this.processOnlyKey = processOnlyKey;
    }

    public int getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(int processUserId) {
        this.processUserId = processUserId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getQualityInspector() {
        return qualityInspector;
    }

    public void setQualityInspector(String qualityInspector) {
        this.qualityInspector = qualityInspector;
    }

    public String getProcessPerson() {
        return processPerson;
    }

    public void setProcessPerson(String processPerson) {
        this.processPerson = processPerson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
