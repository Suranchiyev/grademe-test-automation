package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Driver;
import util.Utils;

public class EvaluatePage {
    WebDriver driver = Driver.getDriver();

    @FindBy(xpath = "//div[text()='Switch to vertical view']/following-sibling::div")
    public WebElement codeEditorElement; // this is not input/textarea

    @FindBy(xpath = "//div/textarea")
    public WebElement codeEditor;

    @FindBy(xpath = "//button[text()='Clear']")
    public WebElement clearBtn;

    @FindBy(xpath = "//button[text()=' Evaluate ']")
    public WebElement evaluateBtn;

    @FindBy(xpath = "//div[contains(text(),'Score:')]")
    public WebElement scoreMsgElement;

    public EvaluatePage() {
        PageFactory.initElements(driver, this);
    }

    public void clearEditor() {
        Utils.wait(2000); // time to page to fully load
        clearBtn.click();
        Utils.wait(1000);
        driver.switchTo().alert().accept();
    }

    public void typeTextToEditor(String txt) {
        codeEditorElement.click();
        Utils.wait(1000);
        codeEditor.sendKeys(txt);
        Utils.wait(1000);
    }

    public String getCaseStatusMessage(String caseNumber) {
        WebElement caseElement = driver.findElement(By.xpath("//div[contains(text(), 'Score')]/../ul/li["+caseNumber+"]//div[@class='col-11']/div[2]"));
        return caseElement.getText().replace("\"", "").trim();
    }

    public String getCompilationError() {
        WebElement caseElement = driver.findElement(By.xpath("//div[contains(text(), 'Score')]/../ul/div"));
        String errorTxt =  caseElement.getText().trim();
        return errorTxt.substring(errorTxt.indexOf("Project.java:"));
    }
}
