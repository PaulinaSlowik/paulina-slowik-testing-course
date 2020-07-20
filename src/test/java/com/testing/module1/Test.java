package com.testing.module1;

public class Test {
    public static void main(String[] args) {
        //instancja klasy StringCalculator
        StringCalculator calculator = new StringCalculator();
        //wywołanie metody add dla jednej liczby
        int result = calculator.add("2");
        //skorzystanie z wcześniej napisanej metody aby sprawdzić czy wynik zwracany przez kalkulator jest zgodny z oczekiwaniami
        System.out.println(areEqual(2,result, "Calculator should return number when number given"));
        //sprawdzenie wyniku dla dwóch liczb
        System.out.println(areEqual(3, calculator.add("2,1"),"Calculator should return sum of numbers when two numbers given"));
    }

    private static Object areEqual(int expected, int actual, String s) {
        if (actual == expected){
            return s + " - passed";
        }
        return s + " - failed";
    }
}
