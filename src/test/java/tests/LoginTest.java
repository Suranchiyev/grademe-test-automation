package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import util.ConfigReader;
import util.CustomReader;
import util.Driver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    //@Test
    public void logInTest() {
        logIn();
    }

//    @Test
//    public void logInTestTwo() {
//       // logIn();
//       // Assert.fail();
//    }

//    public void logIn() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get(ConfigReader.readProperty("url"));
//
//        WebElement email = driver.findElement(By.name("email"));
//        WebElement password = driver.findElement(By.name("password_logIn"));
//        WebElement logInBtn = driver.findElement(By.xpath("//button[text()='Log In']"));
//
//        email.sendKeys(ConfigReader.readProperty("username"));
//        password.sendKeys(ConfigReader.readProperty("password"));
//        logInBtn.click();
//        //driver.quit();
//    }

//    public WebDriver logIn() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//        driver.get(ConfigReader.readProperty("url"));
//
//        WebElement email = driver.findElement(By.name("email"));
//        WebElement password = driver.findElement(By.name("password_logIn"));
//        WebElement logInBtn = driver.findElement(By.xpath("//button[text()='Log In']"));
//
//        email.sendKeys(ConfigReader.readProperty("username"));
//        password.sendKeys(ConfigReader.readProperty("password"));
//        logInBtn.click();
//
//        return driver;
//        //driver.quit();
//    }

    public void logIn() {
        WebDriver driver = Driver.getDriver();

        driver.get(ConfigReader.readProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.logIn();

//        WebElement email = loginPage.usernameInput;
//        WebElement password = loginPage.passwordInput;
//        WebElement logInBtn = loginPage.logInBtn;
//
//        email.sendKeys(ConfigReader.readProperty("username"));
//        password.sendKeys(ConfigReader.readProperty("password"));
//        logInBtn.click();

        //driver.quit();
    }
}
