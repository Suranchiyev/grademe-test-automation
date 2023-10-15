package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.ConfigReader;
import util.Driver;

public class LogInPage {

    public LogInPage() {
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    public WebElement usernameInput;

    @FindBy(name = "password_logIn")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log In']")
    public WebElement logInBtn;

    public void logIn() {
        usernameInput.sendKeys(ConfigReader.readProperty("username"));
        passwordInput.sendKeys(ConfigReader.readProperty("password"));
        logInBtn.click();
    }
}
