@tag
Feature: Verify E2E cucumber features validations with test website

  @Register
  Scenario: Verify user registration is unsuccessful when checkbox not checked
    Given user has navigated to "https://rahulshettyacademy.com/#/index" URL
    When user clicks on "Register" link
    And user enters all manadatory fields except checkbox and click on Register button
    Then verify error message is displayed
    
  @Login
  Scenario: Verify user navigate to login page successfully
    Given user has navigated to "https://rahulshettyacademy.com/#/index" URL
    When user clicks on "Login" link
    Then verify login page is displayed

 