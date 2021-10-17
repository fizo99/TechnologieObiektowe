package com.example.lab01.controller;

import com.example.lab01.model.CurrencyContainer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLCurrenciesParser implements XMLParser<CurrencyContainer> {
    private static final ObjectMapper mapper = new XmlMapper();

    @Override
    public CurrencyContainer parse(String xml) throws JsonProcessingException {
        return mapper.readValue(xml, CurrencyContainer.class);
    }
}
