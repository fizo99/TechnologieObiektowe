package com.example.lab01.view;

import com.example.lab01.model.Exchange;

public class CurrencyExchangeConsoleView {
    private final String GREETING_MESSAGE = "Currency exchange";
    private final String ASK_FOR_FIRST_CURRENCY_CODE_MESSAGE = "Wprowadz kod pierwszej waluty";
    private final String ASK_FOR_SECOND_CURRENCY_CODE_MESSAGE = "Wprowadz kod drugiej waluty";
    private final String ASK_FOR_FIRST_CURRENCY_QUANTITY_MESSAGE = "Wprowadz ilosc pierwszej waluty";
    private final String RESULT_MESSAGE = "Wymieniono %f%s na %f%s";
    private final String ERROR_MESSAGE = "Blad: %s";

    public void askForFirstCurrencyQuantity() {
        System.out.println(ASK_FOR_FIRST_CURRENCY_QUANTITY_MESSAGE);
    }

    public void displayGreeting() {
        System.out.println(GREETING_MESSAGE);
    }

    public void askForFirstCurrency() {
        System.out.println(ASK_FOR_FIRST_CURRENCY_CODE_MESSAGE);
    }

    public void askForSecondCurrency() {
        System.out.println(ASK_FOR_SECOND_CURRENCY_CODE_MESSAGE);
    }

    public void displayResult(Exchange exchange) {
        System.out.printf((RESULT_MESSAGE) + "%n",
                exchange.getExchangedCurrencyQuantity(),
                exchange.getExchangedCurrency(),
                exchange.getTargetCurrencyQuantity(),
                exchange.getTargetCurrency());
    }

    public void displayError(String error) {
        System.out.printf((ERROR_MESSAGE) + "%n", error);
    }
}
