package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class FileUtils {
    private FileUtils () {

    }

    public static String readFileContent(String filePath) {
        StringBuilder result = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(
                new FileReader(filePath))) {
            bufferedReader.lines().forEach(line -> {
                result.append(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
