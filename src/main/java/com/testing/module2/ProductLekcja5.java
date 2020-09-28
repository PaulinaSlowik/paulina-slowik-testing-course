package com.testing.module2;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductLekcja5 {
    UUID id;
    BigDecimal netPrice;
    String type; //np. ubrania, owoce, inne rzeczy z innym Vatem

    public ProductLekcja5(UUID id, BigDecimal netPrice, String type){
        this.id = id;
        this.netPrice = netPrice;
        this.type = type;
    }

    public BigDecimal getNetPrice(){
        return netPrice;
    }
}