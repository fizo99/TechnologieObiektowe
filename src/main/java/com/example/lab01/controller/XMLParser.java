package com.example.lab01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public interface XMLParser<T> {
    T parse(String xml) throws JsonProcessingException;
}
