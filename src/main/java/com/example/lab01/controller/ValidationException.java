package com.example.lab01.controller;

public class ValidationException extends RuntimeException{
    public ValidationException(String msg) {
        super(msg);
    }
}
