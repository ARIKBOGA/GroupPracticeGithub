@Smoke @Regression @logout
Feature: As a user, I should be able to log out.

  Background: User is already logged in.
    Given User goes to login page
    When User enters "Employee11" username
    And User enters "Employee123" password
    And User clicks on login button
    Then User should be logged in

  Scenario: User can log out and ends up in login page
    Given User click to settings expand button on top-right corner
    When Click to Log out button
    Then User should be able to logged out successfully and can see the login page

  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Given User click to settings expand button on top-right corner
    When Click to Log out button
    Then User should be able to logged out successfully and can see the login page
    And User should not be able to go to home page again by clicking step back button