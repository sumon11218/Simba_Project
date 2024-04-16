Feature: Logout Functionality

  Scenario: Logging out of system
    Given I am logged into the system
    When I click on the logout button
    Then I should be redirected to the login page
