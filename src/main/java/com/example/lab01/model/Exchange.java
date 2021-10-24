package com.example.lab01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange {
    private float firstCurrencyQuantity;
    private CurrencyCode firstCurrencyCode;
    private CurrencyCode secondCurrencyCode;
}
