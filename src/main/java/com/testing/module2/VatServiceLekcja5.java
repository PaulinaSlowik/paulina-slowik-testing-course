package com.testing.module2;

import java.math.BigDecimal;
import java.math.MathContext;

//VatServiceLekcja5 korzysta z zewnętrznego providera do wyciągania wartości Vat
public class VatServiceLekcja5 {
    //Interfejs VatProvider
    VatProvider vatProvider;

    public VatServiceLekcja5(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    // metoda która zwraca Vat domyślny, to mogłaby być wartość domyślna dla danego rynku

    public BigDecimal getGrossPriceForDefaultVat(ProductLekcja5 productLekcja5) throws IncorrectVatException{
        return calculateGrossPrice(productLekcja5.getNetPrice(), vatProvider.getDefaultVat());
    }

    //metoda określająca Vat dla konkretnego typu produktu

    public BigDecimal getGrossPrice(BigDecimal netPrice, String productType)throws IncorrectVatException {
        BigDecimal vatValue = vatProvider.getVatForType(productType);
        return calculateGrossPrice(netPrice, vatValue);
    }

    private BigDecimal calculateGrossPrice(BigDecimal netPrice, BigDecimal vatValue) throws IncorrectVatException{
        MathContext m = new MathContext(4);

        if (vatValue.compareTo(BigDecimal.ONE) == 1){
            throw new IncorrectVatException("VAT must be lower!");
        }
        return netPrice.multiply(vatValue.add(BigDecimal.ONE)).round(m);
    }
}