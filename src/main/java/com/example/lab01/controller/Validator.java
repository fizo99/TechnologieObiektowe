package com.example.lab01.controller;

public interface Validator<T> {
    T validate(String data) throws ValidationException;
}
