package steps;

import io.cucumber.java.en.Given;
import pages.LogInPage;

public class LogInSteps {
    @Given("I log in to grademe with valid credentials")
    public void i_log_in_to_grademe_with_valid_credentials() {
        LogInPage logInPage = new LogInPage();
        logInPage.logIn();
    }
}
