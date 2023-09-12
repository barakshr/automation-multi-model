package com.team.api.payload;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Payload {

    public static String getJsonPayload(String path, List<Param> paramList) {
        String updatedText = getJsonPayload(path);
        for (Param param : paramList) {
            String paramName = param.getParamName();
            Object paramValue = param.getParamValue();
            String newString;
            if (paramValue.getClass().equals(String.class)) {
                newString = paramName;
            } else {
                newString = String.format("\"%s\"", paramName);
            }
            updatedText = updatedText.replaceAll(newString, paramValue.toString());
        }
        return updatedText;
    }

    public static String getJsonPayload(String path) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("api-payloads/" + path);
        return new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
