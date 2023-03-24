package com.example.agriculture.entity;

/**
 * 用户
 */
public class User {
    private static final long serialVersionUID = 1L;

    private int userId;
    private String userName;
    private String password;
    //0 管理员  1 种植商 2 运输商 3 储运商 4 经销商
    private String userFlag;
    private String account;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
