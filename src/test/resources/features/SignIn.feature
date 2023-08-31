@regression
Feature: Sign in Feature

  @smoke
  Scenario: Verify user can sign in into Retail Application
    Given User is on the retail home page
    When User click on sign in option
    And User enter email 'student@tekschool.us' and password 'Tek@school'
    And User click on login button
    Then User should be logged in into account

  @smoke
  Scenario: Verify user can create an account into Retail Website
    Given User is on the retail home page
    When User click on sign in option
    And User click on Create New Account button
    And User fill the signUp information with below date
      | StudentC | StudentC12223@gmail.com | Tek@09874 | Tek@09874 |
    And User click on SignUp button
    Then User should be logged into account page