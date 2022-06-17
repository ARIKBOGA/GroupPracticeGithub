Feature: As a user, I should be able to login.


  # Negative Scenario: Login with invalid credentials
  @wip
  Scenario Outline: User shouldn' be able to login with invalid credentials
    Given User goes to login page
    When User enters invalid "<username>" or leaves the input blank username
    When User enters invalid "<password>" or leaves the input blank password
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
