package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Utils {
    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executeJSInDOM(WebDriver driver, String jsScript) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsScript);
    }
}
