package com.testing.module2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyClassTest {
    @Test
    void shouldSumUpTwoNumbers() {
        //given
        int first = 2;
        int second = 3;

        //when
        int result = first + second;

        //then
        assertEquals(5, result);
    }
}