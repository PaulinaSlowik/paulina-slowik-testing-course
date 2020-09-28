package com.testing.module2;

//dodany wyjątek aby nie używać generycznego typu Exception i został dodany IncorrectVatException
public class IncorrectVatException extends Throwable{
    private String message;

    public IncorrectVatException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}