package com.example.lab01.model;

import com.example.lab01.controller.FlexibleFloatDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "pozycja")
public class Currency {
    @JacksonXmlProperty(localName = "nazwa_waluty")
    private String name;
    @JacksonXmlProperty(localName = "przelicznik")
    private int converter;
    @JacksonXmlProperty(localName = "kod_waluty")
    private CurrencyCode code;
    @JsonDeserialize(using = FlexibleFloatDeserializer.class, as = Float.class)
    @JacksonXmlProperty(localName = "kurs_sredni")
    private Float exchangeRate;

    public Currency(String name, int converter, CurrencyCode code, Float exchangeRate) {
        this.name = name;
        this.converter = converter;
        this.code = code;
        this.exchangeRate = exchangeRate;
    }

    public Currency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConverter() {
        return converter;
    }

    public void setConverter(int converter) {
        this.converter = converter;
    }

    public CurrencyCode getCode() {
        return code;
    }

    public void setCode(CurrencyCode code) {
        this.code = code;
    }

    public Float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}