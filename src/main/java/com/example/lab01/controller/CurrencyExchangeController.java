package com.example.lab01.controller;

import com.example.lab01.controller.exception.InvalidCurrencyException;
import com.example.lab01.controller.validator.ValidationException;
import com.example.lab01.model.Exchange;
import com.example.lab01.view.CurrencyExchangeConsoleView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;
    private final CurrencyExchangeConsoleView view;

    private final CurrencyExchangeInputReader inputReader = new CurrencyExchangeInputReader();

    public void start() {
        view.displayGreeting();
        while (true) {
            processExchange();
        }
    }

    private void processExchange() {
        Exchange exchange = new Exchange();
        try {
            view.askForFirstCurrency();
            updateFirstCurrency(exchange);

            view.askForSecondCurrency();
            updateSecondCurrency(exchange);

            view.askForFirstCurrencyQuantity();
            updateFirstCurrencyQuantity(exchange);

            var result = currencyExchangeService.calculateResult(exchange);
            view.displayResult(result.toString());
        } catch (ValidationException | InvalidCurrencyException exception) {
            view.displayError(exception.getMessage());
        }
    }

    private void updateFirstCurrencyQuantity(Exchange exchange) {
        var firstCurrencyQuantity = inputReader.getNextFloat();
        exchange.setFirstCurrencyQuantity(firstCurrencyQuantity);
    }

    private void updateFirstCurrency(Exchange exchange) {
        var currencyCode = inputReader.getNextCurrencyCode();
        exchange.setFirstCurrencyCode(currencyCode);
    }

    private void updateSecondCurrency(Exchange exchange) {
        var currencyCode = inputReader.getNextCurrencyCode();
        exchange.setSecondCurrencyCode(currencyCode);
    }
}
