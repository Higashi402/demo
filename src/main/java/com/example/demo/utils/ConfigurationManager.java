package com.example.demo.utils;

import java.util.ResourceBundle;

public class ConfigurationManager {
    private final static ResourceBundle resourceBundle =
            ResourceBundle.getBundle("messages");

    // класс извлекает информацию из файла messages.properties
    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}