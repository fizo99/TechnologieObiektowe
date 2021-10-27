package com.example.lab01.service;

import com.example.lab01.controller.exception.InvalidCurrencyException;
import com.example.lab01.mapper.XMLMapper;
import com.example.lab01.model.Currency;
import com.example.lab01.model.CurrencyCode;
import com.example.lab01.remote.RemoteProvider;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.example.lab01.model.CurrencyCode.PLN;

@Getter
@JacksonXmlRootElement(localName = "tabela_kursow")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateTable {
    private static ExchangeRateTable instance;
    @JacksonXmlProperty(localName = "numer_tabeli")
    private String tableNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JacksonXmlProperty(localName = "data_publikacji")
    private Date publishDate;
    @JacksonXmlProperty(localName = "pozycja")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Currency> currencies;

    private ExchangeRateTable() {
    }

    public static ExchangeRateTable getInstance() throws RuntimeException {
        try {
            if (instance == null) instance = prepareExchangeRateTable();
            return instance;
        } catch (IOException exception) {
            throw new RuntimeException("Unable to read exchange rate remote data. " + exception.getMessage());
        }
    }

    private static ExchangeRateTable prepareExchangeRateTable() throws IOException {
        var xml = RemoteProvider.get("https://www.nbp.pl/kursy/xml/lasta.xml");
        var exchangeRateTable = XMLMapper.map(xml, ExchangeRateTable.class);

        exchangeRateTable.currencies.add(new Currency("złoty (Polska)", 1, PLN, 1.0f));
        return exchangeRateTable;
    }

    public Currency getByCode(CurrencyCode currencyCode) throws InvalidCurrencyException {
        return currencies.stream()
                .filter(currency -> currency.getCode().equals(currencyCode))
                .findFirst()
                .orElseThrow(() -> new InvalidCurrencyException("Unknown currency " + currencyCode));
    }


}