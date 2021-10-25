package com.example.lab01.validator;

public class FloatValidator implements Validator<Float> {
    @Override
    public Float validate(String data) {
        try {
            return Float.parseFloat(data);
        } catch (NumberFormatException exception) {
            throw new ValidationException("Invalid float value: " + data);
        }
    }
}
