@RetailRegression
Feature: Retail Account Page

  Background:
    Given User is on the retail home page
    When User click on sign in option
    And User enter email 'student13@gmail.com' and password 'Tek@09874'
    And User click on login button
    And User should be logged in into account

  @userUpdateInfo
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Smaile' and Phone '2405553430'
    And User click on Update button
    Then user profile information should be updated

  @userAddCardPayment
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1223455667781234 | Guardian   | 12              | 25             | 888          |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’

  @UserEditInfo
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 1223455667781235 | Guardian   | 12              | 2028           | 777          |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @UserRemoveCardInfo
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    And User click on remove option of card section
    Then payment details should be removed

  @UserAddAddressInfo
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country          | fullName | phoneNumber | streetAddress | apt      | city   | state | zipCode |
      | 1223455667781235 | John Doe | 2053434434  | 1234          | building | Valkan | Idaho | 20444   |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @UserEditAddressInfo
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information
      | country          | fullName | phoneNumber | streetAddress | apt      | city   | state | zipCode |
      | 1223455667781235 | John Doe | 2053634434  | 1264          | building | Valkan | Idaho | 20446   |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully’

  @UserRemoveAddressInfo
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed