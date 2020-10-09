package com.testing.module2.homework;

public interface VatProvider {

    double getDefaultVat();

    double getVatForType(String type);
}
