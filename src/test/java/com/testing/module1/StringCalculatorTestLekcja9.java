package com.testing.module1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTestLekcja9 {
    //pole klasy testowej
     StringCalculator calculator;

    @Test
    void shouldReturnANumberWhenNumberGiven() {
        createCalculator();
        //metoda assertEquals jest stworzona w bibliotece JUnit
        assertEquals(2,calculator.add("2"));
    }

    @Test
    void shouldSumTwoNumbersWhenTwoNumbersGiven() {
        createCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
    //wyciągnięcie do oddzielnych metod powtarzający się kod
    //logika implementująca wyciągnięta do zewnętrznej metody
    private void createCalculator() {
        calculator = new StringCalculator();
    }
}
