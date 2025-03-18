@Feature_File_LoginAddProductsToCart @LoginAddProductsToCart
Feature: Login and Add Products to Cart

  Scenario Outline: Login with valid credentials and Add Multiple Products
    Given the user opens the SwagLabs app
    When the user enters a valid username "<username>" and password "<password>"
    And the user clicks the login button
    And the app navigates to the home screen
    And the user adds products to the cart
    Then the products are added to the cart successfully
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | standard      | secret       |
