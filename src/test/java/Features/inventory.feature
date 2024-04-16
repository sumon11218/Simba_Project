Feature: Inventory Page Functionality

  Scenario: Viewing Product Details
    Given I am on logged into the system
    And I am on the inventory page
    When I click on a product
    And I am directed to the specific product page
    Then I should see detailed information about the product


