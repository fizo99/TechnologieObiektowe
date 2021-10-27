package com.example.lab01.validator;

public class FloatValidator implements Validator<Float> {
    @Override
    public Float validate(String data) {
        try {
            var value = Float.parseFloat(data);
            if(value == Float.POSITIVE_INFINITY)
                throw new NumberFormatException("value too high");
            if(value <= 0.0f)
                throw new NumberFormatException("value too low");
            return value;
        } catch (NumberFormatException exception) {
            throw new ValidationException("Invalid value: " + data + ". " + exception.getMessage());
        }
    }
}
