package com.testing.module2.homework;

import com.testing.module2.IncorrectVatException;

public class VatService {
    VatProvider vatProvider;

    public VatService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public double getGrossPriceForDefaultVat(Product product) throws IncorrectVatException {
        return calculateGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
    }

    public double getGrossPrice(double netPrice, String productType) throws IncorrectVatException {
        double vatValue = vatProvider.getVatForType(productType);
        return calculateGrossPrice(netPrice, vatValue);
    }

    private double calculateGrossPrice(double netPrice, double vatValue) throws IncorrectVatException {
        if (vatValue > 1) {
            throw new IncorrectVatException("VAT must be lower!");
        }
        return netPrice * (1 + vatValue);
    }
}