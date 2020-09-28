package com.testing.module2.homework;

import com.testing.module2.IncorrectVatException;

public class VatService {
    double vatValue;

    public VatService() {
        this.vatValue = 0.23;
    }

    public double getGrossPriceForDefaultVat(Product product) throws IncorrectVatException {
        return getGrossPrice(product.getNetPrice(), vatValue);
    }

    public double getGrossPrice(double netPrice, double vatValue) throws IncorrectVatException {
        if (vatValue > 1) {
            throw new IncorrectVatException("VAT must be lower!");
        }
        return netPrice * (1 + vatValue);
    }
}
