package com.example.lab01.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class DataProvider {
    public static String get(String url) throws IOException {
        var connectionURL = new URL(url);
        var conn = (HttpURLConnection) connectionURL.openConnection();
        conn.setRequestMethod("GET");
        try (var reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            return reader.lines().collect(Collectors.joining());
        }
    }
}
