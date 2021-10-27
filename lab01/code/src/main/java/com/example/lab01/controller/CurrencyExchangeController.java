package com.example.lab01.controller;

import com.example.lab01.controller.exception.InvalidCurrencyException;
import com.example.lab01.model.Exchange;
import com.example.lab01.service.CurrencyExchangeService;
import com.example.lab01.validator.ValidationException;
import com.example.lab01.view.CurrencyExchangeConsoleView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CurrencyExchangeController {
    private final CurrencyExchangeInputReader inputReader = new CurrencyExchangeInputReader();
    private final CurrencyExchangeService currencyExchangeService;
    private final CurrencyExchangeConsoleView view;

    public void start() {
        view.displayGreeting();
        while (true) {
            processExchange();
        }
    }

    private void processExchange() {
        Exchange exchange = new Exchange();
        try {
            view.askForExchangedCurrency();
            updateExchangedCurrency(exchange);

            view.askForTargetCurrency();
            updateTargetCurrency(exchange);

            view.askForExchangedCurrencyQuantity();
            updateExchangedCurrencyQuantity(exchange);

            updateTargetCurrencyQuantity(exchange);
            view.displayResult(exchange);
        } catch (ValidationException | InvalidCurrencyException exception) {
            view.displayError(exception.getMessage());
        }
    }

    private void updateExchangedCurrencyQuantity(Exchange exchange) {
        var exchangedCurrencyQuantity = inputReader.getNextFloat();
        exchange.setExchangedCurrencyQuantity(exchangedCurrencyQuantity);
    }

    private void updateExchangedCurrency(Exchange exchange) {
        var currencyCode = inputReader.getNextCurrencyCode();
        exchange.setExchangedCurrency(currencyCode);
    }

    private void updateTargetCurrency(Exchange exchange) {
        var currencyCode = inputReader.getNextCurrencyCode();
        exchange.setTargetCurrency(currencyCode);
    }

    private void updateTargetCurrencyQuantity(Exchange exchange) {
        var targetCurrencyQuantity = currencyExchangeService.calculateTargetCurrencyQuantity(exchange);
        exchange.setTargetCurrencyQuantity(targetCurrencyQuantity);
    }
}
