package com.example.agriculture.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CommonUse {

    private static final long serialVersionUID = 1L;
    private int saleId;
    private int logisticsId;
    private int planterId;
    private int processId;
    private int planterUserId;
    private String planterOnlyKey;
    private String planterName;//植物名称
    private String temperature;
    private String envHumidity;//环境湿度
    private String ph;
    private String light;
    private String soilHumidity;//土壤湿度
    private int logisticsUserId;
    private String logisticsOnlyKey;
    private String location;//仓储地点
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date inTime;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outTime;
    private String transportPerson;
    private String leaveAddress;
    private String arriveAddress;
    private int processUserId;
    private String processOnlyKey;
    private String factoryName;
    private String qualityInspector;//只见人员
    private String processPerson;//加工人员
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;//加工时间
    private int saleUserId;
    private String mallName;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date saleTime;
    private String price;
    private String saleOnlyKey;
    private int userId;
    private String userName;
    private String password;
    //0 管理员  1 种植商 2 运输商 3 储运商 4 经销商
    private String userFlag;
    private String account;

    public String getPlanterName() {
        return planterName;
    }

    public void setPlanterName(String planterName) {
        this.planterName = planterName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(int logisticsId) {
        this.logisticsId = logisticsId;
    }

    public int getPlanterId() {
        return planterId;
    }

    public void setPlanterId(int planterId) {
        this.planterId = planterId;
    }

    public int getProcessId() {
        return processId;
    }

    public void setProcessId(int processId) {
        this.processId = processId;
    }

    public int getPlanterUserId() {
        return planterUserId;
    }

    public void setPlanterUserId(int planterUserId) {
        this.planterUserId = planterUserId;
    }

    public String getPlanterOnlyKey() {
        return planterOnlyKey;
    }

    public void setPlanterOnlyKey(String planterOnlyKey) {
        this.planterOnlyKey = planterOnlyKey;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getEnvHumidity() {
        return envHumidity;
    }

    public void setEnvHumidity(String envHumidity) {
        this.envHumidity = envHumidity;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(String soilHumidity) {
        this.soilHumidity = soilHumidity;
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

    public int getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(int processUserId) {
        this.processUserId = processUserId;
    }

    public String getProcessOnlyKey() {
        return processOnlyKey;
    }

    public void setProcessOnlyKey(String processOnlyKey) {
        this.processOnlyKey = processOnlyKey;
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



    public int getSaleUserId() {
        return saleUserId;
    }

    public void setSaleUserId(int saleUserId) {
        this.saleUserId = saleUserId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSaleOnlyKey() {
        return saleOnlyKey;
    }

    public void setSaleOnlyKey(String saleOnlyKey) {
        this.saleOnlyKey = saleOnlyKey;
    }
}
