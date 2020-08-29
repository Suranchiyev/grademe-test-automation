package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.ConfigReader;
import util.Driver;

public class LoginPage {

    public LoginPage() {
       // WebDriver driver = new ChromeDriver();
        WebDriver driver = Driver.getDriver();
        usernameInput = driver.findElement(By.name("email"));
        passwordInput = driver.findElement(By.name("password_logIn"));
        logInBtn = driver.findElement(By.xpath("//button[text()='Log In']"));
    }

    public WebElement usernameInput;
    public WebElement passwordInput;
    public WebElement logInBtn;

    public void logIn() {
        usernameInput.sendKeys(ConfigReader.readProperty("username"));
        passwordInput.sendKeys(ConfigReader.readProperty("password"));
        logInBtn.click();
    }
}
