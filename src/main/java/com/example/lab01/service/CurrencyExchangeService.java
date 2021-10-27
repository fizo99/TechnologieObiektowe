package com.example.lab01.service;

import com.example.lab01.model.Exchange;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyExchangeService {
    private final ExchangeRateTable exchangeRateTable;

    public Float calculateTargetCurrencyQuantity(Exchange exchange) {
        var exchangedCurrency = exchangeRateTable.getByCode(exchange.getExchangedCurrency());
        var targetCurrency = exchangeRateTable.getByCode(exchange.getTargetCurrency());
        var exchangedCurrencyQuantity = exchange.getExchangedCurrencyQuantity();

        return exchangedCurrencyQuantity * exchangedCurrency.getExchangeRate()
                / exchangedCurrency.getConverter()
                / targetCurrency.getExchangeRate() * targetCurrency.getConverter();
    }
}