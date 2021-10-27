package com.example.lab01.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLMapper {
    private static final ObjectMapper mapper = new XmlMapper();

    public static <T> T map(String xml, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(xml, clazz);
    }
}
