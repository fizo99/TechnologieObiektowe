package com.example.lab01;

import com.example.lab01.controller.CurrencyExchangeController;
import com.example.lab01.service.CurrencyExchangeService;
import com.example.lab01.service.ExchangeRateTable;
import com.example.lab01.view.CurrencyExchangeConsoleView;

public class App {
    public static void main(String[] args) {
        var app = new App();
        app.run();
    }

    public void run() {
        var exchangeView = new CurrencyExchangeConsoleView();
        var exchangeService = new CurrencyExchangeService(ExchangeRateTable.getInstance());
        var controller = new CurrencyExchangeController(exchangeService, exchangeView);

        controller.start();
    }


}

