package com.example.lab01.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange {
    private float exchangedCurrencyQuantity;
    private CurrencyCode exchangedCurrency;
    private CurrencyCode targetCurrency;
    private float targetCurrencyQuantity;
}
