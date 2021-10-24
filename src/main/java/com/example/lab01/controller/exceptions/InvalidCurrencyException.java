package com.example.lab01.controller.exceptions;

public class InvalidCurrencyException extends RuntimeException{
    public InvalidCurrencyException(String msg) {
        super(msg);
    }
}
