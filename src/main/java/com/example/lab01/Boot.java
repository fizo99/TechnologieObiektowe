package com.example.lab01;

import com.example.lab01.controller.DataProvider;
import com.example.lab01.mapper.XMLMapper;
import com.example.lab01.model.ExchangeRateTable;

import java.io.IOException;

public class Boot {

    public static void main(String[] args) throws IOException {

        var xml = DataProvider.get("https://www.nbp.pl/kursy/xml/lasta.xml");
        var exchangeRateContainer = XMLMapper.map(xml, ExchangeRateTable.class);

        System.out.println("abc");
        System.out.println("bca");
    }

}
