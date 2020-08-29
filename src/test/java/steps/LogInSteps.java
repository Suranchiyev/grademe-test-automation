package steps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.LogInPageRef;
import util.ConfigReader;
import util.Driver;

public class LogInSteps {

    @Given("I log in to grademe with valid credentials")
    public void i_log_in_to_grademe_with_valid_credentials() {
        LogInPageRef logInPageRef = new LogInPageRef();
        WebDriver driver = Driver.getDriver();
        driver.get(ConfigReader.readProperty("url"));

        logInPageRef.logIn();
    }
}
