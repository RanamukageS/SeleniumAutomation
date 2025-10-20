package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private  static Properties properties;

    public static void loadProperties() {
        try {
            FileInputStream fis = new FileInputStream("/Users/shashikaranamukage/Documents/Code/OrangeHRM/OrangeHRM/src/test/java/resources/Data/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }

}
