package com.example.lab01;

import com.example.lab01.controller.CurrencyExchangeController;
import com.example.lab01.controller.CurrencyExchangeService;
import com.example.lab01.controller.DataProvider;
import com.example.lab01.model.Exchange;
import com.example.lab01.mapper.XMLMapper;
import com.example.lab01.model.ExchangeRateTable;
import com.example.lab01.view.ExchangeConsoleView;

import java.io.IOException;

public class Boot {

    public static void main(String[] args) throws IOException {
        var xml = DataProvider.get("https://www.nbp.pl/kursy/xml/lasta.xml");
        var exchangeRateTable = XMLMapper.map(xml, ExchangeRateTable.class);
        var exchangeService = new CurrencyExchangeService(exchangeRateTable);

        var model = new Exchange();
        var view = new ExchangeConsoleView();
        var controller = new CurrencyExchangeController(exchangeService, view, model);

        controller.mainLoop();
    }
}
