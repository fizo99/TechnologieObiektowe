package com.example.lab01.controller.validator;

import com.example.lab01.model.CurrencyCode;

public class CurrencyCodeValidator implements Validator<CurrencyCode> {
    @Override
    public CurrencyCode validate(String data) {
        try {
            return CurrencyCode.valueOf(data.toUpperCase());
        } catch (IllegalArgumentException | NullPointerException exception) {
            throw new ValidationException("Invalid currency code value: " + data);
        }
    }
}
