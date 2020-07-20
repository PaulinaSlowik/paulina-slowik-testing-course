package com.testing.module1;

public class StringCalculatorLekcja9 {
    public int add(String input) {
        //jeśli dostajemy pusty String to zwracamy zero
        if (input.isEmpty()) {
            return 0;
        }
        //jeśli dostajemy w Stringu (który jest argumentem tej metody) jedną liczbę to zwracamy tą liczbę
        String[] numbers = input.split(",");
        if (numbers.length == 1) {
            String number = numbers[0];
            return getIntFrom(number);
        } else {
            //jeśli dostajemy kilka liczb po przecinku to sumujemy te liczby
            return getIntFrom(numbers[0]) + getIntFrom(numbers[1]);
        }
    }

    private int getIntFrom(String number){
        return Integer.parseInt(number);
    }
}
