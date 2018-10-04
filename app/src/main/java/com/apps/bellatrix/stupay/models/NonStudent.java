package com.apps.bellatrix.stupay.models;

public class NonStudent {
    int shopId;
    String name;
    double currentBalance;

    public NonStudent() {
    }

    public NonStudent(int shopId, String name, double currentBalance) {
        this.shopId = shopId;
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public int getShopId() {
        return shopId;
    }

    public String getName() {
        return name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
