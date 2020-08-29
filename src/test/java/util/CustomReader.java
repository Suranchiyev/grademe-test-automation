package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomReader {
    private static final Map<String, String> properties;

    static {
        properties = new HashMap<>();

        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/configuration.properties"))) {

            String line;
            while( (line = bufferedReader.readLine()) != null ) {
                properties.put(line.trim().split("=")[0], line.trim().split("=")[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readProperty(String key) {
        return properties.get(key);
    }
}
