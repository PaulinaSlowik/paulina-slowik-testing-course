package com.testing.module2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class VatServiceTest {
    VatService vatService;

    @Test
    @DisplayName("should calculate gross price for default VAT")
        //test dla domyślnego Vatu
    void shouldCalculateGrossPriceForDefaultVat() throws Exception {
        //given, mówi o tym jakie jest srodowisko w którym odpalamy testy
        //tworzenie produktu, produkt wrzucony do zmiennej
        Product product = generateProductWithPrice("20.00");

        //when, to moment kiedy wywołujemy główną funkcjonalność
        //wywołanie metody na obiekcie do wyliczenia ceny brutto
        //to co wyrzuci VatService wrzucam też do jakiegoś rezutatu
        BigDecimal result = vatService.getGrossPriceForDefaultVat(product);

        //then

        //asercja przy pomocy biblioteki AssertJ
        assertThat(result).isEqualTo(new BigDecimal("24.60"));

        //asercja przy pomocy biblioteki JUnit5
        //sprawdzenie czy cena brutto wyniesie 24.60
        assertEquals(new BigDecimal("24.60"), result);
    }

    @Test
    void shouldCalculateGrossPriceForOtherVatValue() throws Exception {
        //given
        Product product = generateProductWithPrice("10.00");
        //when
        BigDecimal result = vatService.getGrossPrice(product.getNetPrice(), new BigDecimal("0.08"));
        //then
        //asercja przy pomocy biblioteki AssertJ
        assertThat(result).isEqualTo(new BigDecimal("10.80"));

        //asercja przy pomocy biblioteki JUnit5
        assertEquals(new BigDecimal("10.80"), result);
    }

    //test sprawdzający wyjątek
    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() {
        //given
        Product product = generateProductWithPrice("10.00");
        //then
        //asercja przy pomocy biblioteki AssertJ
        assertThatExceptionOfType(Exception.class).isThrownBy(
                ()->{
                    vatService.getGrossPrice(product.getNetPrice(), BigDecimal.TEN);
                });


        //asercja przy pomocy biblioteki JUnit5
        //sekcja when jest nie potrzebna bo wszystko wydazy sie w miejscu na asercje
        assertThrows(Exception.class,()->{
                vatService.getGrossPrice(product.getNetPrice(), BigDecimal.TEN);
        });
    }

    private Product generateProductWithPrice(String vat) {
        return new Product(UUID.randomUUID(), new BigDecimal(vat));
    }

    //metoda która przygotowuje nam środowisko przed każdym testem
    @BeforeEach
    void prepareVatService() {
        //obiekt klasy VatService
        vatService = new VatService();
    }
}