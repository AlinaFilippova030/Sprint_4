package ru.config;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try {
            // Загрузить файла config.properties из папки resources
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getBrowser() {
        return properties.getProperty("browser", "chrome"); // По умолчанию Chrome
    }
}