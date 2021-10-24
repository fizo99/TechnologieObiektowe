package com.example.lab01.controller.validator;

public interface Validator<T> {
    T validate(String data) throws ValidationException;
}
