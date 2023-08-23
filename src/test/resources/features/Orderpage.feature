@OrderRegression
Feature: Retail Order Page

  @UserAddItem
  Scenario: Verify User can add an item to cart
    Given User is on the retail home page
    When User click on sign in option
    And User enter email 'student13@gmail.com' and password 'Tek@09874'
    And User click on login button
    And User should be logged in into account
    And User change the category to 'Smart Home'
    And User search for an item 'kasa outdoor smart plug'
    And User click on Search icon
    And User click on item
    And User select quantity '2'
    And User click add to Cart button
    Then the cart icon quantity should change to '2'

  @UserPlaceOrder
  Scenario: Verify User can place an order with Shipping address and payment Method on file
    Given User is on retail website
    When User click on sign in option
    And User enter email 'student13@gmail.com' and password 'Tek@09874'
    And User click on login button
    And User should be logged in into account
    And User change the category to 'Electronics'
    And User search for an item 'Apex Legends'
    And User click on Search icon
    And User click on item
    And User select quantity '5'
    And User click add to Cart button
    Then the cart icon quantity should change to '5'
    And User click on Cart option
    And User click on Proceed to Checkout button
    And User click on Place Your Order
    Then a message should be displayed ‘Order Placed, Thanks’

 # Note: For the below scenarios,
 # you need to first have orders in place.
 # At least one order must be present

  @UserCancelOrder
  Scenario: Verify User can cancel the order
    Given User is on retail website
    When User click on sign in option
    And User enter email 'student13@gmail.com' and password 'Tek@09874'
    And User click on login button
    And User should be logged in into account
    And User click on Orders section
    And User click on first order in list
    And User click on Cancel The Order button
    And User select the cancellation Reason 'Bought wrong item'
    And User click on Cancel Order button
    Then a cancellation message should be displayed 'Your Order Has Been Cancelled'

  @UserReturnOrder
  Scenario: Verify User can Return the order
    Given User is on retail website
    When User click on sign in option
    And User enter email 'student13@gmail.com' and password 'Tek@09874'
    And User click on login button
    And User should be logged in into account
    And User click on Orders section
    And User click on first order in list
    And User click on Return Items button
    And User select the Return Reason 'Item damaged'
    And User select the drop off service 'FedEx'
    And User click on Return Order button
    Then a cancellation message should be displayed 'Return was successful'

  @UserUpdateOrder
  Scenario: Verify User can write a review on order placed
    Given User is on retail website
    When User click on sign in option
    And User enter email 'student13@gmail.com' and password 'Tek@09874'
    And User click on login button
    And User should be logged in into account
    And User click on Orders section
    And User click on first order in list
    And User click on Review button
    And User write Review headline ' headline value' and 'review text'
    And User click Add your Review button
    Then a review message should be displayed ‘Your review was added successfully’