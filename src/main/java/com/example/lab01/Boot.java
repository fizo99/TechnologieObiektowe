package com.example.lab01;

import com.example.lab01.controller.DataProvider;
import com.example.lab01.controller.XMLCurrenciesParser;
import com.example.lab01.model.CurrencyCode;

import java.io.IOException;

public class Boot {

    public static void main(String[] args) throws IOException {


        var xml = DataProvider.get("https://www.nbp.pl/kursy/xml/lasta.xml");
        var xmlParser = new XMLCurrenciesParser();

        var currenciesList = xmlParser.parse(xml);
        var currency = currenciesList.getByCode(CurrencyCode.AUD);

        System.out.println("abc");
        System.out.println("bca");
    }

}
