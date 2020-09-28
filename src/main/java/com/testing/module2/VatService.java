package com.testing.module2;

import java.math.BigDecimal;
import java.math.MathContext;

//serwis który za pomocą ceny netto wyznacza nam cenę brutto
public class VatService {
    BigDecimal vatValue;

    public VatService() {
        this.vatValue = new BigDecimal(0.23);
    }

    public BigDecimal getGrossPriceForDefaultVat(Product product) throws Exception{
        return getGrossPrice(product.getNetPrice(),vatValue);
    }

    public BigDecimal getGrossPrice(BigDecimal netPrice, BigDecimal vatValue) throws Exception{
        MathContext m = new MathContext(4);
        //nie pozwalamy na to aby Vat był większy od 1
        //metoda compareTo zwraca 0 jeśli wartośći są równe a jeśli pierwsza jest wyższa to zwraca 1
        if (vatValue.compareTo(BigDecimal.ONE) == 1){
            throw new Exception("VAT must be lower!");
        }
        return netPrice.multiply(vatValue.add(BigDecimal.ONE)).round(m);
    }
}