package com.sofisticat.stockmanagerbackend.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Utils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static ObjectMapper SystemMapper() {
        return objectMapper;
    }
}
