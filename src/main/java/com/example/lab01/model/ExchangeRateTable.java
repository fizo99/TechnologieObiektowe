package com.example.lab01.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Getter
@JacksonXmlRootElement(localName = "tabela_kursow")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateTable {

    @JacksonXmlProperty(localName = "numer_tabeli")
    private String tableNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JacksonXmlProperty(localName = "data_publikacji")
    private Date publishDate;

    @JacksonXmlProperty(localName = "pozycja")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Currency> currencies;

    public Optional<Currency> getByCode(CurrencyCode currencyCode) {
        return currencies.stream()
                .filter(currency -> currency.getCode().equals(currencyCode))
                .findFirst();
    }
}