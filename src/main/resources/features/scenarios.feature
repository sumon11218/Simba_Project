Feature: Login Functionality
  Scenario: Login with Valid Credentials
    Given I am on the login page
    When I enter valid credentials
    And click on the login button
    Then I should be taken to the Products page

Feature: Login Functionality
  Scenario: Login with Invalid Credentials
    Given I am on the login page
    When I enter invalid credentials
    And click on the login button
    Then I should see an error message indicating invalid credentials

Feature: Cart Functionality
  Scenario: Adding Product to Cart
    Given I am on the Products page
    When I select a product
    And click on 'Add to Cart'
    Then the product should be added to the cart successfully

Feature: Cart Functionality
  Scenario: Removing Product from Cart
    Given I have added a product to the cart
    When I navigate to the cart page
    And click on ‘Remove’
    Then the product should be removed from the cart successfully

Feature: Product Page Functionality
  Scenario: Viewing Product Details
    Given I am on the Products page
    When I click on a product
    And I am directed to the specific product page
    Then I should see detailed information about the product

Feature: Cart Functionality
  Scenario: Adding Multiple Products to Cart
    Given I am on the Products page
    When I add multiple products to the cart
    Then all selected products should be added to the cart

Feature: Checkout Functionality
  Scenario: Checking out with products in cart
    Given I have products in the cart
    And I click on ‘Checkout’ button
    When I enter my information
    And click on ‘Continue’ button’
    And click ‘Finish’
    Then the order should be successfully processed
    And I should receive a confirmation message

Feature: Checkout Functionality
  Scenario: Handling Empty Text Fields at Checkout
    Given I am on the 'Checkout: Your Information' page
    When I fail to input information in a required text field
    And proceed by clicking 'Continue'
    Then I should receive an error message prompting me to fill in the missing information.

Feature: Checkout Functionality
  Scenario: Proceeding with Empty Cart at Checkout
    Given I have an empty cart
    When I try to continue without any items in my cart
    And I enter my information
    And click on ‘Continue’
    Then I should receive an error message indicating an empty cart
    And I won't be able to proceed until I have added items to my cart.

Feature: Logout Functionality
  Scenario: Logging out of system
    Given I am logged into the system
    When I click on the logout button
    Then I should be logged out of the system
    And redirected to the login page


