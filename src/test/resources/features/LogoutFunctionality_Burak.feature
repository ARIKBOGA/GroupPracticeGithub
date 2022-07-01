@Smoke @Regression @logout @MTSK-401
Feature: As a user, I should be able to log out.


  @MTSK-399
  Scenario: User can log out and ends up in login page
    Given User logs in with valid credentials
    Given User click to settings expand button on top-right corner
    When Click to Log out button
    Then User should be able to logged out successfully and can see the login page

  @MTSK-400
  Scenario: User can not go to home page again by clicking step back button after successfully logged out.
    Given User logs in with valid credentials
    Given User click to settings expand button on top-right corner
    When Click to Log out button
    Then User should be able to logged out successfully and can see the login page
    And User should not be able to go to home page again by clicking step back button