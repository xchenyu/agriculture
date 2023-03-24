package com.example.agriculture.entity;

import java.util.Date;

/**
 * 加工商
 */
public class Logistics {
    private static final long serialVersionUID = 1L;

    private int logisticsId;
    private int logisticsUserId;
    private String logisticsOnlyKey;
    private String location;//仓储地点
    private Date inTime;
    private Date outTime;
    private String transportPerson;
    private String leaveAddress;
    private String arriveAddress;

    public int getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public int getLogisticsUserId() {
        return logisticsUserId;
    }

    public void setLogisticsUserId(int logisticsUserId) {
        this.logisticsUserId = logisticsUserId;
    }

    public String getLogisticsOnlyKey() {
        return logisticsOnlyKey;
    }

    public void setLogisticsOnlyKey(String logisticsOnlyKey) {
        this.logisticsOnlyKey = logisticsOnlyKey;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getTransportPerson() {
        return transportPerson;
    }

    public void setTransportPerson(String transportPerson) {
        this.transportPerson = transportPerson;
    }

    public String getLeaveAddress() {
        return leaveAddress;
    }

    public void setLeaveAddress(String leaveAddress) {
        this.leaveAddress = leaveAddress;
    }

    public String getArriveAddress() {
        return arriveAddress;
    }

    public void setArriveAddress(String arriveAddress) {
        this.arriveAddress = arriveAddress;
    }
}
