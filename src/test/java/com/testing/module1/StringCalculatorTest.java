package com.testing.module1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    //pole klasy testowej
    StringCalculator calculator;

    @BeforeEach
    //wyciągnięcie do oddzielnych metod powtarzający się kod
    //logika implementująca wyciągnięta do zewnętrznej metody
    private void createCalculator() {
        calculator = new StringCalculator();
    }

    @Test
    void shouldReturnZeroWhenGivenZero() {
        assertEquals(0, calculator.add("0"));
        assertThat(calculator.add("0")).isEqualTo(0);
    }

    @Test
    void shouldSumThreeNumbersWhenThreeNumbersGiven() {

        assertEquals(6, calculator.add("1,2,3"));
        assertThat(calculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    void shouldReturnCorrectSumWithNegativeNumbersGive() {

        assertEquals(-1, calculator.add("-2,1"));
        assertThat(calculator.add("-2,1")).isEqualTo(-1);
    }
}