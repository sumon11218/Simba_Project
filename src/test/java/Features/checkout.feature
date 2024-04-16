Feature: Checkout Functionality

  Scenario: Checking out with products in cart
    Given I am logged in to my account
    And I navigate to the inventory page
    And I have added products in the cart
    And I navigate to the my cart page
    And I click on ‘Checkout’ button
    When I enter my information
    And click on ‘Continue’ button
    And click ‘Finish’
    Then I should receive a confirmation message


  Scenario: Handling Empty Text Fields at Checkout
    Given I have connected to my account
    And I add products to my cart
    And I navigate to the cart page
    And I click on the checkout button
    And I am redirected to the 'Checkout: Your Information' page
    When I proceed by clicking 'Continue'
    Then I should receive an error message prompting me to fill in the missing information


  Scenario: Proceeding with Empty Cart at Checkout
    Given I am logged into my account
    When I go to the my cart page
    And I click on checkout
    And I enter my information in the text fields
    And click on ‘Continue’
    And click on ‘Finish’
    Then I should receive an error message indicating an empty cart
