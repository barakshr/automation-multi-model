package com.team.api.properties;


import com.team.selenium.BrowserType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {

    public static void readProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("apiconfig.properties");
        properties.load(inputStream);
        Settings.AUT = properties.getProperty("AUT");
        Settings.HeaderTypeKey = properties.getProperty("HeaderTypeKey");
        Settings.HeaderTypeValue = properties.getProperty("HeaderTypeValue");
    }
}
