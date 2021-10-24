package com.example.lab01.controller.exception;

public class InvalidCurrencyException extends RuntimeException {
    public InvalidCurrencyException(String msg) {
        super(msg);
    }
}
