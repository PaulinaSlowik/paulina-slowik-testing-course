package com.testing.module1;
import static org.springframework.util.ObjectUtils.isEmpty;

//kalkulator Stringów
public class StringCalculator {
    public int add(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        String[] numbers = input.split(",");
        int result = 0;
        for (String number : numbers) {
            result += getIntFrom(number);
        }
        return result;
    }

    private int getIntFrom(String number) {
        return Integer.parseInt(number);
    }
}