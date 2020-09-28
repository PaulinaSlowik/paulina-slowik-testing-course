package com.testing.module2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

public class VatServiceTestLekcja5 {

    VatServiceLekcja5 vatServiceLekcja5;
    VatProvider vatProvider;

    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() throws IncorrectVatException {
        //given
        when(vatProvider.getDefaultVat()).thenReturn(new BigDecimal("0.23"));
        ProductLekcja5 productLekcja5 = generateProduct("20.00","Clothes");

        //when
        BigDecimal result = vatServiceLekcja5.getGrossPriceForDefaultVat(productLekcja5);

        //then
        assertThat(result).isEqualTo(new BigDecimal("24.60"));
    }

    @Test
    void shouldCalculateGrossPriceForOtherVatValue() throws IncorrectVatException {
        //given
        String type = "Books";
        ProductLekcja5 productLekcja5 = generateProduct("10.00", type);
        when(vatProvider.getVatForType(type)).thenReturn(new BigDecimal("0.08"));
        //when
        BigDecimal result = vatServiceLekcja5.getGrossPrice(productLekcja5.getNetPrice(), type);
        //then
        assertThat(result).isEqualTo(new BigDecimal("10.80"));
    }

    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() {
        //given
        String type = "Clothes";
        ProductLekcja5 product = generateProduct("10.00", type);
        when(vatProvider.getVatForType(type)).thenReturn(BigDecimal.TEN);
        //then
        assertThatExceptionOfType(IncorrectVatException.class).isThrownBy(()-> {
            vatServiceLekcja5.getGrossPrice(product.getNetPrice(), type);
        }).withMessage(("VAT must be lower!"));
    }

    private ProductLekcja5 generateProduct(String netPrice, String type) {
        return new ProductLekcja5(UUID.randomUUID(), new BigDecimal(netPrice), type);
    }

    @BeforeEach
    void prepareVatService() {
        vatProvider = Mockito.mock(VatProvider.class);
        vatServiceLekcja5 =  new VatServiceLekcja5(vatProvider);
    }
}
