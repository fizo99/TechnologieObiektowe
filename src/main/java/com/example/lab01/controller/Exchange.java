package com.example.lab01.controller;

import com.example.lab01.model.Currency;
import com.example.lab01.model.CurrencyCode;
import com.example.lab01.model.ExchangeRateTable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange {
    private float firstCurrencyQuantity;
    private Currency firstCurrency;
    private Currency secondCurrency;

    public Float calculateResult() {
        return firstCurrencyQuantity * firstCurrency.getExchangeRate() / firstCurrency.getConverter()
                / secondCurrency.getExchangeRate() * secondCurrency.getConverter();
    }
}
