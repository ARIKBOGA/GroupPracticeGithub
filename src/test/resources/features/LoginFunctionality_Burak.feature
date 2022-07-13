@Smoke @Regression @login @MTSK-372
Feature: As a user, I should be able to login.

  @PositiveScenario  @ValidLogin @MTSK-373
  Scenario Outline: User can login with valid credentials
    Given User goes to login page
    When User enters "<user name>" username
    And User enters "<pass word>" password
    And User clicks on login button
    Then User should be logged in
    Examples:
      | user name  | pass word   |
      | Employee71 | Employee123 |
      | Employee11 | Employee123 |
      | Employee21 | Employee123 |

  @NegativeScenario @InvalidLogin @MTSK-374
  Scenario Outline: User can not login with any invalid credentials
  -"Please fill out this field." message should be displayed if the password or username is empty
  -"Wrong username or password." should be displayed for invalid credentials
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
      | empLOyee11 | Employee123 |

  @PositiveScenario @MTSK-375
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

  @PositiveScenario @MTSK-376
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

  @PositiveScenario @MTSK-377
  Scenario: User can see the "Forgot password?" link on the login page
  and can see the "Reset Password" button
  on the next page after clicking on forget password link
    Given User goes to login page
    When User clicks on Forgot password link
    Then User should see the Reset Password button


  @PositiveScenario @MTSK-371
  Scenario: User can see valid placeholders on Username and Password fields
    Given User goes to login page
    When User sees the "Username or email" and "Password" placeholders


  @MTSK-403
  Scenario Outline: User should see an error message after trying with credentials that has
  less than 2 or more than 15 characters
    Given User goes to login page
    When User enters "<username>" username
    When User enters "<password>" password
    When User clicks on login button
    Then User shouldn't be able to login and should see error message
    Examples:
      | username         | password         |
      | E                | Employee123      |
      | Employee71Employ | Employee123      |
      | Employee71       | Employee123Emplo |
      | Employee71       | X                |