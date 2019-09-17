Feature: Some sample manual tests

  As a qa using serenity bdd
  I want to test different options for updating manual scenarios result
  In order to have one full report with all results placed in

  @manual @regression
  Scenario: User logs in the site
    Given login page is open
    When user logs in with correct credentials
    Then user's home page is open

  @manual @regression
  Scenario: User registration
    Given registration page is open
    When user enters his/her details
    Then user is successful registered

  @manual @regression
  Scenario: User orders a product
    Given shopping page is open
    When user enters his/her details
    Then user is successful registered