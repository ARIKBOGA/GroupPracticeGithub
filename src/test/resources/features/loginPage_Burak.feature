@Smoke @Regression @login
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
      | Employee11 | Employee123 |
      | Employee21 | Employee123 |

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

  @PositiveScenario
  Scenario Outline: User can see the password in a form of dots by default
    Given User goes to login page
    When User enters "<password>" password
    Then User should see the password in a form of dots
    Examples:
      | password     |
      | Employee123. |
      | -Amazon01    |
      | Java_*07     |
      | Selenium     |

  @PositiveScenario
  Scenario Outline: User can see the password explicitly if needed by clicking on the eye icon
    Given User goes to login page
    When User enters "<password>" password
    And User clicks on eye icon
    Then User should see the password in a form of text
    Examples:
      | password     |
      | Employee123. |
      | -Amazon01    |
      | Java_*07     |
      | Selenium     |

  @PositiveScenario
  Scenario: User can see the "Forgot password?" link on the login page
  and can see the "Reset Password" button
  on the next page after clicking on forget password link
    Given User goes to login page
    When User clicks on Forgot password link
    Then User should see the Reset Password button


  @PositiveScenario
  Scenario: User can see valid placeholders on Username and Password fields
    Given User goes to login page
    When User sees the "Username or email" and "Password" placeholders