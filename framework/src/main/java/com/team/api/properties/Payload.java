package com.team.api.properties;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Payload {

    public static String readPayloadJson(String path, List<Param> params) {
        String text = readPayloadJson(path);
        for (Param param : params) {
            String paramName = param.getParamName();
            Object paramValue = param.getParamValue();
            String type = param.getType();
            String newString = "";
            if (type.equals("string")) {
                newString = paramName;
            } else {
                newString = String.format("\"%s\"", paramName);
            }
            text = text.replaceAll(newString, paramValue.toString());
        }

        return "";
    }

    public static String readPayloadJson(String path) {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("api-payloads/" + path);
        String text = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
        return text;
    }
}
