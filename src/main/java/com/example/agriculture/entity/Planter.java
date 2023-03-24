package com.example.agriculture.entity;

import java.util.Date;

/**
 * 种植商
 */
public class Planter {
    private static final long serialVersionUID = 1L;

    private int planterUserId;
    private String planterOnlyKey;
    private String temperature;
    private String envHumidity;//环境湿度
    private String ph;
    private String light;
    private String soilHumidity;//土壤湿度
    private String planterName;//植物名称
    private int planterId;


    public String getPlanterName() {
        return planterName;
    }

    public void setPlanterName(String planterName) {
        this.planterName = planterName;
    }

    public int getPlanterId() {
        return planterId;
    }

    public void setPlanterId(int planterId) {
        this.planterId = planterId;
    }


    public String getPlanterOnlyKey() {
        return planterOnlyKey;
    }

    public void setPlanterOnlyKey(String planterOnlyKey) {
        this.planterOnlyKey = planterOnlyKey;
    }

    public int getPlanterUserId() {
        return planterUserId;
    }

    public void setPlanterUserId(int planterUserId) {
        this.planterUserId = planterUserId;
    }

    public String getSoilHumidity() {
        return soilHumidity;
    }

    public void setSoilHumidity(String soilHumidity) {
        this.soilHumidity = soilHumidity;
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


}
