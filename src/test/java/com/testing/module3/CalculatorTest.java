package com.testing.module3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @Test
    void shouldReturnZeroWhenEmptyStringGiven() {
        //Given
        //When
        double result = calculator.add("");
        //Then
        assertEquals(0.0, result);
        assertThat(result).isEqualTo(0.0);
    }

    @Test
    void shouldReturnOneWhenOneGiven() {
        //Given
        //When
        double result = calculator.add("1.0");
        //Then
        assertThat(result).isEqualTo(1.0);
    }

    @Test
    void shouldReturnSumOfTwoNumbers() {
        //Given
        //When
        double result = calculator.add("1.0,2.0");
        //Then
        assertThat(result).isEqualTo(3.0);
    }

    @Test
    void shouldReturnSumOfThreeNumbers() {
        //Given
        //When
        double result = calculator.add("1.0,2.0,3.0");
        //Then
        assertThat(result).isEqualTo(6.0);
    }

    @Test
    void shouldReturnSumOfThreeNumbersAndNewLine() {
        //Given
        //When
        double result = calculator.add("3.0,2.0\n4.0");
        //Then
        assertThat(result).isEqualTo(9.0);
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
}