package com.example.lab01.view;

import java.util.Scanner;

public class ExchangeConsoleView {
    private final Scanner scan = new Scanner(System.in);

    private final String GREETING_MESSAGE = "Currency exchange";
    private final String ASK_FOR_FIRST_CURRENCY_CODE_MESSAGE = "Wprowadz kod pierwszej waluty";
    private final String ASK_FOR_SECOND_CURRENCY_CODE_MESSAGE = "Wprowadz kod drugiej waluty";
    private final String ASK_FOR_FIRST_CURRENCY_QUANTITY_MESSAGE = "Wprowadz ilosc pierwszej waluty";
    private final String RESULT_MESSAGE = "Wynik: %s";
    private final String ERROR_MESSAGE = "Blad: %s";

    public String askForFirstCurrencyQuantity() {
        System.out.println(ASK_FOR_FIRST_CURRENCY_QUANTITY_MESSAGE);
        return getInput();
    }

    public void displayGreeting() {
        System.out.println(GREETING_MESSAGE);
    }

    public String askForFirstCurrency() {
        System.out.println(ASK_FOR_FIRST_CURRENCY_CODE_MESSAGE);
        return getInput();
    }

    public String askForSecondCurrency() {
        System.out.println(ASK_FOR_SECOND_CURRENCY_CODE_MESSAGE);
        return getInput();
    }

    public void displayResult(String result) {
        System.out.printf((RESULT_MESSAGE) + "%n", result);
    }

    public void displayError(String error) {
        System.out.printf((ERROR_MESSAGE) + "%n", error);
    }

    public String getInput() {
        return scan.nextLine();
    }
}
