package com.testing.module2.homework;

public class Product {
    String id;
    double netPrice;
    String type;

    public Product(String id, double netPrice, String type) {
        this.id = id;
        this.netPrice = netPrice;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public String getType() {
        return type;
    }
}