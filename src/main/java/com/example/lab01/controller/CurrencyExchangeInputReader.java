package com.example.lab01.controller;

import com.example.lab01.controller.validator.CurrencyCodeValidator;
import com.example.lab01.controller.validator.FloatValidator;
import com.example.lab01.controller.validator.ValidationException;
import com.example.lab01.controller.validator.Validator;
import com.example.lab01.model.CurrencyCode;

import java.util.Scanner;

public class CurrencyExchangeInputReader {
    private final Scanner scan = new Scanner(System.in);
    private final Validator<Float> floatValidator = new FloatValidator();
    private final Validator<CurrencyCode> currencyCodeValidator = new CurrencyCodeValidator();

    public Float getNextFloat() throws ValidationException {
        return floatValidator.validate(scan.nextLine());
    }

    public CurrencyCode getNextCurrencyCode() throws ValidationException {
        return currencyCodeValidator.validate(scan.nextLine());
    }
}
