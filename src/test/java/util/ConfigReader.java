package util;

import java.io.*;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;

    static {
        properties = new Properties();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/resources/configuration.properties"))) {

            properties.load(bufferedReader);

        } catch (IOException e1){
            e1.printStackTrace();
        }
    }


    public static String readProperty(String property){
        return properties.getProperty(property);
    }
}
