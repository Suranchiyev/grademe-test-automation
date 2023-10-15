package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Driver;

public class DashboardPage {
    WebDriver driver = Driver.getDriver();

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateTo(String weekName, String assignmentName) {
        String weekXpath = String.format("//span[text()='%s']/../../div/button", weekName);
        WebElement weekExpander = driver.findElement(By.xpath(weekXpath));
        weekExpander.click();
        String assignmentXpath = String.format("//a[contains(text(), '%s')]", assignmentName);
        WebElement assignmentLink = driver.findElement(By.xpath(assignmentXpath));
        assignmentLink.click();
    }
}
