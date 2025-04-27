Feature: Automate and validate a complete login and purchase flow with cart price validation


  Scenario: Purchase the 2 most expensive items and complete checkout
    Given user is on the Swag Labs login page
    When user enters "standard_user" and "secret_sauce"
    And user clicks the login button
    And user applies the "Price (low to high)" filter on the product list
    And user identifies and adds the two most expensive products to the cart
    And user navigates to the cart page
    Then cart should contain exactly 2 items
    When user proceeds to checkout
    And user enters first name "John", last name "Doe", and postal code "226001"
    And user completes the checkout process
    Then the confirmation page should display the message "Thank you for your order!"
