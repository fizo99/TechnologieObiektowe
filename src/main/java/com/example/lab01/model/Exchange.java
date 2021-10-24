package com.example.lab01.model;

import com.example.lab01.model.Currency;
import com.example.lab01.model.CurrencyCode;
import com.example.lab01.model.ExchangeRateTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange {
    private float firstCurrencyQuantity;
    private CurrencyCode firstCurrencyCode;
    private CurrencyCode secondCurrencyCode;
}
