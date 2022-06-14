@Regression
Feature: Verify that "file summary" footer works properly after creating a file

  Background: User is on the dashboard page
    Given I should be logged in as a user with credentials "Employee71" and "Employee123"


  Scenario Outline: Verify that "file summary" footer works properly after creating a file
    Given I am on the dashboard page
    Given Click to  plus icon
    And Click to New text document link
    And Enter the "<fileName>" to the File name field (with extension)
    When Press enter from keyboard and Click to X button on the file edit page
    Then Check if the file summary footer numbers are correct
    Examples:
      | fileName |
      | yut.md   |
