package utils;

import java.io.*;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static void loadProperties() {
        String fileName = "config.properties";
        try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            properties = new Properties();
            properties.load(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }

}
