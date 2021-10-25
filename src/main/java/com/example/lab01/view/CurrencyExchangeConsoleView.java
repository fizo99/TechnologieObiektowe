package com.example.lab01.view;

import com.example.lab01.model.Exchange;

public class CurrencyExchangeConsoleView {
    private final String GREETING_MESSAGE = "Currency exchange";
    private final String ASK_FOR_EXCHANGED_CURRENCY_CODE_MESSAGE = "Wprowadz kod wymienianej waluty";
    private final String ASK_FOR_TARGET_CURRENCY_CODE_MESSAGE = "Wprowadz kod waluty na ktora wymieniasz";
    private final String ASK_FOR_EXCHANGED_CURRENCY_QUANTITY_MESSAGE = "Wprowadz ilosc wymienianej waluty";
    private final String RESULT_MESSAGE = "Wymieniono %f%s na %f%s";
    private final String ERROR_MESSAGE = "Blad: %s";

    public void askForExchangedCurrencyQuantity() {
        System.out.println(ASK_FOR_EXCHANGED_CURRENCY_QUANTITY_MESSAGE);
    }

    public void displayGreeting() {
        System.out.println(GREETING_MESSAGE);
    }

    public void askForExchangedCurrency() {
        System.out.println(ASK_FOR_EXCHANGED_CURRENCY_CODE_MESSAGE);
    }

    public void askForTargetCurrency() {
        System.out.println(ASK_FOR_TARGET_CURRENCY_CODE_MESSAGE);
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
