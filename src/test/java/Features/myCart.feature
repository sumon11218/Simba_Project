Feature: Cart Functionality

  Scenario: Adding Product to Cart
    Given I log into an account
    And I am on the Inventory page
    When I select a product
    And click on 'Add to Cart'
    Then the product should be added to the cart successfully

  Scenario: Removing Product from Cart
    Given I am logged in
    And I have added a product to the cart
    When I visit the cart page
    And click on ‘Remove’
    Then the product should be removed from the cart successfully

  Scenario: Adding Multiple Products to Cart
    Given I have access to my account
    And I am redirected to the Inventory page
    When I add multiple products to the cart
    Then all selected products should be added to the cart


