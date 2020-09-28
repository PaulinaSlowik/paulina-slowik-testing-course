package com.testing.module2.homework;

import com.testing.module2.IncorrectVatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VatServiceTest {
    VatService vatService;
    Product product;

    @BeforeEach
    void setUp() {
        vatService = new VatService();
    }

    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() throws IncorrectVatException {
        //Given
        product = new Product("Product 1", 20.00);
        //When
        double result = vatService.getGrossPriceForDefaultVat(product);
        //Then
        assertThat(result).isEqualTo((24.60));
        assertEquals(24.60, result);
    }

    @Test
    @DisplayName("should calculate gross price for other VAT value")
    void shouldCalculateGrossPriceForOtherVatValue() throws IncorrectVatException {
        //Given
        product = new Product("Product 2", 10.00);
        //When
        double result = vatService.getGrossPrice(product.getNetPrice(), 0.08);
        //Then
        assertThat(result).isEqualTo((10.80));
        assertEquals(10.80, result);
    }

    @Test
    @DisplayName("should throw exception when VAT is too high")
    void shouldThrowExceptionWhenVatIsTooHigh() {
        //Given
        product = new Product("Product 3", 100.00);
        //Then
        assertThatExceptionOfType(IncorrectVatException.class).isThrownBy(() -> {
            vatService.getGrossPrice(product.getNetPrice(), Double.MAX_VALUE);
        }).withMessage(("VAT must be lower!"));
        assertThrows(IncorrectVatException.class, () -> {
            vatService.getGrossPrice(product.getNetPrice(), Double.MAX_VALUE);
        });
    }
}