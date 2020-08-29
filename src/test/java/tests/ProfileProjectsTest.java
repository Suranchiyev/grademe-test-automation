package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import util.Driver;

public class ProfileProjectsTest {

//    @Test
//    public void testName() {
//        LoginTest loginTest = new LoginTest();
//        loginTest.logIn();
//
//        WebDriver driver = new ChromeDriver();
//        WebElement nameElement = driver.findElement(By.xpath("//h4[1]"));
//        System.out.println(nameElement.getText());
//
//        Assert.assertEquals("John Doe", nameElement.getText().trim());
//    }

    @Test
    public void testName() {
        LoginTest loginTest = new LoginTest();
        loginTest.logIn();

        // WebDriver driver = new ChromeDriver();
        // WebDriver driver = loginTest.logIn();
        WebDriver driver = Driver.getDriver();

        WebElement nameElement = driver.findElement(By.xpath("//h4[1]"));
        System.out.println(nameElement.getText());

        Assert.assertEquals("John Doe", nameElement.getText().trim());
    }
}
