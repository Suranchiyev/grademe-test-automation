package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import util.ConfigReader;
import util.Driver;

public class Hooks {
    @Before
    public void setUp() {
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.readProperty("url"));
    }

    @After
    public void tearDown() {
        Driver.killDriver();
    }
}
