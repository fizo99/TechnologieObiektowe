package com.example.lab01.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown=true)
@JacksonXmlRootElement(localName = "tabela_kursow")
public class CurrencyContainer {
    @JacksonXmlProperty(localName = "pozycja")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Currency> currencies;

    public Optional<Currency> getByCode(CurrencyCode currencyCode) {
        return currencies.stream()
                .filter(currency -> currency.getCode().equals(currencyCode))
                .findFirst();
    }
}