package com.example.agriculture.entity;

import java.util.Date;

/**
 * 经销商
 */
public class Sale {
    private static final long serialVersionUID = 1L;

    private int saleId;
    private int saleUserId;
    private String mallName;
    private Date saleTime;
    private String price;
    private String saleOnlyKey;

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getSaleOnlyKey() {
        return saleOnlyKey;
    }

    public void setSaleOnlyKey(String saleOnlyKey) {
        this.saleOnlyKey = saleOnlyKey;
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


}
