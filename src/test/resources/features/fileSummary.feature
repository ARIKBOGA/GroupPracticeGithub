
Feature: Verify that "file summary" footer works properly after creating a file

  Background:
    Given I should be logged in as a user with credentials "Employee71" and "Employee123"

  Scenario Outline: Verify that "file summary" footer works properly after creating a file
    Given I am on the dashboard page
    When Click to  plus icon
    And Click to New text document link
    And Enter the "<fileName>" to the File name field (with extension)
    And Press enter from keyboard and Click to X button on the file edit page
    Then Check if the file summary footer numbers are correct
    Examples:
      | fileName    |
      | file_1.md   |
      | file_2.txt  |
      | file_3.java |