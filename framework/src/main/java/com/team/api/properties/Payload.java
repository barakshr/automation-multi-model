package com.team.api.properties;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class Payload {

    public static String readPayloadJson(String path) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("api-payloads/"+path);
        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }
}
