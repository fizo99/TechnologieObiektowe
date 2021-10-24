package com.example.lab01.controller;

import com.example.lab01.model.Exchange;
import com.example.lab01.model.ExchangeRateTable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyExchangeService {
    private final ExchangeRateTable exchangeRateTable;

    public Float calculateResult(Exchange exchange) {
        var firstCurrency = exchangeRateTable.getByCode(exchange.getFirstCurrencyCode());
        var secondCurrency = exchangeRateTable.getByCode(exchange.getSecondCurrencyCode());
        var firstCurrencyQuantity = exchange.getFirstCurrencyQuantity();

        return firstCurrencyQuantity * firstCurrency.getExchangeRate()
                / firstCurrency.getConverter()
                / secondCurrency.getExchangeRate() * secondCurrency.getConverter();
    }
}
