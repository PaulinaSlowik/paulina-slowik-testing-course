package com.testing.module2.homework;

public class Product {
    String id;
    double netPrice;

    public Product(String id, double netPrice) {
        this.id = id;
        this.netPrice = netPrice;
    }

    public String getId() {
        return id;
    }

    public double getNetPrice() {
        return netPrice;
    }
}
