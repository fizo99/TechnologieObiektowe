package com.example.lab01.controller;

import com.example.lab01.controller.exceptions.InvalidCurrencyException;
import com.example.lab01.model.CurrencyCode;
import com.example.lab01.model.Exchange;
import com.example.lab01.view.ExchangeConsoleView;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class CurrencyExchangeController {
    private final CurrencyExchangeService currencyExchangeService;
    private final ExchangeConsoleView view;
    private final Exchange exchange;
    private final Scanner scan = new Scanner(System.in);

    private final Validator<Float> floatValidator = new FloatValidator();
    private final Validator<CurrencyCode> currencyCodeValidator = new CurrencyCodeValidator();

    public void mainLoop() {
        view.displayGreeting();
        while (true) {
            try {
                view.askForFirstCurrency();
                updateFirstCurrency(getInput(currencyCodeValidator));

                view.askForSecondCurrency();
                updateSecondCurrency(getInput(currencyCodeValidator));

                view.askForFirstCurrencyQuantity();
                updateFirstCurrencyQuantity(getInput(floatValidator));

                var result = currencyExchangeService.calculateResult(exchange);
                view.displayResult(result.toString());
            } catch (ValidationException | InvalidCurrencyException exception) {
                view.displayError(exception.getMessage());
            }
        }

    }

    public void updateFirstCurrencyQuantity(Float firstCurrencyQuantity) {
        exchange.setFirstCurrencyQuantity(firstCurrencyQuantity);
    }

    private void updateFirstCurrency(CurrencyCode currencyCode) {
        exchange.setFirstCurrencyCode(currencyCode);
    }

    private void updateSecondCurrency(CurrencyCode currencyCode) {
        exchange.setSecondCurrencyCode(currencyCode);
    }

    public <T> T getInput(Validator<T> validator) {
        return validator.validate(scan.nextLine());
    }
}
