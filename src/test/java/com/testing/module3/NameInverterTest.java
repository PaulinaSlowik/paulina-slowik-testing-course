package com.testing.module3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameInverterTest {
    @Test
    void shouldThrowExceptionWhenNullProcided() {
        NameInverter nameInverter = new NameInverter();
        Assertions.assertThrows(NullPointerException.class, () -> {
            nameInverter.inverter(null);
        });
    }
}