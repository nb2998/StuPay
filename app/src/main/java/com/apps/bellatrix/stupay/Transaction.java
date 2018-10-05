package com.apps.bellatrix.stupay;

class Transaction {
    String purpose;
    double amount;
    boolean increment;

    public Transaction(String purpose, double amount, boolean increment) {
        this.purpose = purpose;
        this.amount = amount;
        this.increment = increment;
    }

    public String getPurpose() {
        return purpose;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isIncrement() {
        return increment;
    }
}
