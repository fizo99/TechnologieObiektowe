package com.example.lab01.validator;

public interface Validator<T> {
    T validate(String data) throws ValidationException;
}
