Feature: Code evaluation

  @smoke @regression
  Scenario: Valid code evaluation
    Given I log in to grademe with valid credentials
    And I navigate to "Week 1" and open "hello world" assignment
    And I typed code from "src/test/resources/code/validHelloWorld" to editor
    When I evaluate code and wait for the results
    Then Score message should be "Score: 100% (95% required to complete this project)"
    And Status message of "1" case should be "PASS"

  @smoke @regression
  Scenario: Invalid output code evaluation
    Given I log in to grademe with valid credentials
    And I navigate to "Week 1" and open "hello world" assignment
    And I typed code from "src/test/resources/code/invalidOutputHelloWorld" to editor
    When I evaluate code and wait for the results
    Then Score message should be "Score: 0% (95% required to complete this project)"
    And Status message of "1" case should be "FAILED: org.opentest4j.AssertionFailedError: expected: <Hello, World!> but was: <Hello, world!>"

  @regression
  Scenario: Compilation error evaluation
    Given I log in to grademe with valid credentials
    And I navigate to "Week 1" and open "hello world" assignment
    And I typed code from "src/test/resources/code/invalidSyntaxHelloWorld" to editor
    When I evaluate code and wait for the results
    Then Score message should be "Score: 0% (95% required to complete this project)"
    And Compilation error should be "Project.java:1: error: ';' expected public class Project { public static void main(String[] args)) { System.out.println(\"Hello, world!\"); }} ^"

  @regression
  Scenario: Valid code evaluation with multiple cases
    Given I log in to grademe with valid credentials
    And I navigate to "Week 2" and open "print method" assignment
    And I typed code from "src/test/resources/code/validPrintMethod" to editor
    When I evaluate code and wait for the results
    Then Score message should be "Score: 100% (95% required to complete this project)"
    And Status message of "1" case should be "PASS"
    And Status message of "2" case should be "PASS"

  @regression
  Scenario: Invalid output code evaluation with multiple cases
    Given I log in to grademe with valid credentials
    And I navigate to "Week 2" and open "print method" assignment
    And I typed code from "src/test/resources/code/invalidOutputPrintMethod" to editor
    When I evaluate code and wait for the results
    Then Score message should be "Score: 50% (95% required to complete this project)"
    And Status message of "1" case should be "PASS"
    And Status message of "2" case should be "FAILED: org.opentest4j.AssertionFailedError: expected: <Java is platform-independent! Java is platform-independent! Java is platform-independent! Java is platform-independent! Java is platform-independent!> but was: <Hello Hello Hello Hello Hello>"