package com.testing.module2.homework;

import com.testing.module2.IncorrectVatException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class VatServiceTest {
    VatService vatService;
    VatProvider vatProvider;

    @BeforeEach
    public void setUp() {
        vatProvider = Mockito.mock(VatProvider.class);
        vatService = new VatService(vatProvider);
    }

    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() throws IncorrectVatException {
        //Given
        Product product = new Product("Product 1", 20.00,"Box");
        when(vatProvider.getDefaultVat()).thenReturn(0.23);
        //When
        double result = vatService.getGrossPriceForDefaultVat(product);
        //Then
        assertThat(result).isEqualTo((24.60));
        assertEquals(24.60, result);
        Mockito.verify(vatProvider, Mockito.times(1)).getDefaultVat();
        Mockito.verify(vatProvider, Mockito.never()).getVatForType("Any type");
    }

    @Test
    @DisplayName("should calculate gross price for other VAT value")
    void shouldCalculateGrossPriceForOtherVatValue() throws IncorrectVatException {
        //Given
        String type = "Box";
        Product product = new Product("Product 2", 10.00,type);
        when(vatProvider.getVatForType(type)).thenReturn(0.08);
        //When
        double result = vatService.getGrossPrice(product.getNetPrice(), type);
        //Then
        assertThat(result).isEqualTo((10.80));
        assertEquals(10.80, result);
    }

    @Test
    @DisplayName("should throw exception when VAT is too high")
    void shouldThrowExceptionWhenVatIsTooHigh() {
        //Given
        String type = "Box";
        Product product = new Product("Product 3", 100.00,type);
        when(vatProvider.getVatForType(type)).thenReturn(Double.MAX_VALUE);
        //Then
        assertThatExceptionOfType(IncorrectVatException.class).isThrownBy(() -> {
                    vatService.getGrossPrice(product.getNetPrice(), type);
                });
        assertThrows(IncorrectVatException.class, () -> {
            vatService.getGrossPrice(product.getNetPrice(), type);
        });
    }
}