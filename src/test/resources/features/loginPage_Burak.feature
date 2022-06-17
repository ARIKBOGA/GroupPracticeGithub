@Smoke @Regression
Feature: As a user, I should be able to login.

  @PositiveScenario  @ValidLogin
  Scenario Outline: Login with valid credentials
    Given User goes to login page
    When User enters "<username>" username
    And User enters "<password>" password
    And User clicks on login button
    Then User should be logged in
    Examples:
      | username   | password    |
      | Employee71 | Employee123 |

  @NegativeScenario @InvalidLogin
  Scenario Outline: User can not login with any invalid credentials
  -"Wrong username or password." should be displayed for invalid credentials
  -"Please fill out this field." message should be displayed if the password or username is empty
    Given User goes to login page
    When User enters "<username>" username
    When User enters "<password>" password
    When User clicks on login button
    Then User shouldn't be able to login and should see error message
    Examples:
      | username   | password    |
      |            | Employee123 |
      | Employee71 |             |
      |            |             |
      | Burak007   | Employee123 |
      | Employee71 | CydeoEU8    |
      | Burak007   | CydeoEU8    |