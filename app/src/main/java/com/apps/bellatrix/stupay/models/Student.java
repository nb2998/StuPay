package com.apps.bellatrix.stupay.models;

public class Student {
    int id;
    String name, rollNo;
    double currentBalance;

    public Student() {
    }

    public Student(int id, String name, String rollNo, double currentBalance) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.currentBalance = currentBalance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
