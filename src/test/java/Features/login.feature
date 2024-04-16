Feature: Login Functionality

  Scenario Outline: Login with Valid Credentials
    Given I am on the login page
    When I enter valid Username <username> in text field
    When I enter valid password in text field
    And click on the login button
    Then I should be taken to the Inventory page

    Examples:
    |username|
    |standard_user|
    |locked_out_user|
    |problem_user|
    |performance_glitch_user|
    |error_user|
    |visual_user|

  Scenario: Login with Invalid Credentials
    Given I navigate to the login page
    When I enter invalid username
    When I type in valid password
    And click on login
    Then I should see an error message indicating invalid credentials

