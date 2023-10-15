package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.EvaluatePage;
import util.Driver;
import util.FileUtils;

public class EvaluateSteps {
    private EvaluatePage evaluatePage = new EvaluatePage();
    private DashboardPage dashboardPage = new DashboardPage();

    @Given("I navigate to {string} and open {string} assignment")
    public void i_navigate_to_and_open_assignment(String weekName, String assignmentName) {
        dashboardPage.navigateTo(weekName, assignmentName);
    }

    @Then("I typed code from {string} to editor")
    public void i_typed_code_from_to_editor(String codePath) {
        String code = FileUtils.readFileContent(codePath);
        evaluatePage.clearEditor();
        evaluatePage.typeTextToEditor(code);
    }

    @Then("I evaluate code and wait for the results")
    public void i_evaluate_code_and_wait_for_the_results() {
        evaluatePage.evaluateBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Score:')]")));
    }

    @Then("Score message should be {string}")
    public void score_message_should_be(String scoreMessage) {
        String actualScoreMsg = evaluatePage.scoreMsgElement.getText().trim();
        Assert.assertEquals("Score message is not correct", scoreMessage, actualScoreMsg);
    }

    @Then("Status message of {string} case should be {string}")
    public void status_message_of_case_should_be(String caseNumber, String statusMessage) {
        String actualStatusMessage = evaluatePage.getCaseStatusMessage(caseNumber);
        Assert.assertEquals("Status message is not correct", statusMessage, actualStatusMessage);
    }

    @Then("Compilation error should be {string}")
    public void compilation_error_should_be(String expectedCompilationError) {
        String actualCompilationError = evaluatePage.getCompilationError();
        Assert.assertEquals("Compilation error is not correct", expectedCompilationError, actualCompilationError);
    }
}
