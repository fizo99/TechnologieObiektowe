package com.example.lab01.model;

import com.example.lab01.mapper.deserializer.FloatDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Currency {
    @JacksonXmlProperty(localName = "nazwa_waluty")
    String name;
    @JacksonXmlProperty(localName = "przelicznik")
    int converter;
    @JacksonXmlProperty(localName = "kod_waluty")
    CurrencyCode code;
    @JacksonXmlProperty(localName = "kurs_sredni")
    @JsonDeserialize(using = FloatDeserializer.class, as = Float.class)
    Float exchangeRate;
}