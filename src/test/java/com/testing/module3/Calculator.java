package com.testing.module3;

public class Calculator {
    public double add(String number) {
        if (number.isEmpty()) {
            return 0;
        }

        String[] digits = number.split(",|\n");

        int result = 0;
        for (String digit : digits) {
            result += Double.parseDouble(digit);
        }
        return result;
    }
}