package com.example.lab01.controller;

import com.example.lab01.controller.exceptions.InvalidCurrencyException;
import com.example.lab01.model.Currency;
import com.example.lab01.model.ExchangeRateTable;
import com.example.lab01.view.ExchangeConsoleView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyExchangeController {
    private final ExchangeRateTable exchangeRateTable;
    private final ExchangeConsoleView view;
    private final Exchange exchange;

    public void mainLoop() {
        view.displayGreeting();
        while (true) {
            try {
                changeFirstCurrency();
                changeSecondCurrency();
                changeFirstCurrencyQuantity();

                var result = exchange.calculateResult();
                view.displayResult(result.toString());
            } catch (InvalidCurrencyException | NumberFormatException exception) {
                view.displayError(exception.getMessage());
            }
        }

    }

    private Float validateFloat(String possibleFloat) {
        return Float.parseFloat(possibleFloat);
    }

    private Currency validateCode(String possibleCurrencyCode) {
        return exchangeRateTable.getByCode(possibleCurrencyCode);
    }

    public void changeFirstCurrencyQuantity() {
        var firstCurrencyQuantity = validateFloat(view.askForFirstCurrencyQuantity());
        exchange.setFirstCurrencyQuantity(firstCurrencyQuantity);
    }

    public void changeFirstCurrency() {
        var currency = validateCode(view.askForFirstCurrency());
        exchange.setFirstCurrency(currency);
    }

    public void changeSecondCurrency() {
        var currency = validateCode(view.askForSecondCurrency());
        exchange.setSecondCurrency(currency);
    }
}
