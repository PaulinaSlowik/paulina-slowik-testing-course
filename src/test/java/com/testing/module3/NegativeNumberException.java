package com.testing.module3;

public class NegativeNumberException extends RuntimeException {

    private String message;

    public NegativeNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}