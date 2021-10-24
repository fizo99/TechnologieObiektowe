package com.example.lab01.model;

import com.example.lab01.mapper.deserializer.FloatDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;

@Getter
public class Currency {
    @JacksonXmlProperty(localName = "nazwa_waluty")
    private String name;
    @JacksonXmlProperty(localName = "przelicznik")
    private int converter;
    @JacksonXmlProperty(localName = "kod_waluty")
    private CurrencyCode code;
    @JacksonXmlProperty(localName = "kurs_sredni")
    @JsonDeserialize(using = FloatDeserializer.class, as = Float.class)
    private Float exchangeRate;
}