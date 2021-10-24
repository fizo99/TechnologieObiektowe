package com.example.lab01;

import com.example.lab01.controller.CurrencyExchangeController;
import com.example.lab01.controller.CurrencyExchangeService;
import com.example.lab01.controller.ExchangeRateTable;
import com.example.lab01.view.CurrencyExchangeConsoleView;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        var app = new App();
        app.run();
    }

    public void run() throws IOException {
        var exchangeView = new CurrencyExchangeConsoleView();
        var exchangeService = new CurrencyExchangeService(ExchangeRateTable.getInstance());
        var controller = new CurrencyExchangeController(exchangeService, exchangeView);

        controller.start();
    }


}

