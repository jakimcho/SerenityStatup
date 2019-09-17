Feature: Some sample manual tests

  As a qa using serenity bdd
  I want to test different options for updating manual scenarios result
  In order to have one full report with all results placed in

  @manual @regression
  @manual-result:passed
  @manual-last-tested:sprint-15
  Scenario: User logs in the site
    Given login page is open
    When user logs in with correct credentials
    Then user's home page is open

  @manual @regression
  @manual-result:failed
  @manual-test-evidence:assets/bug.png
  @manual-last-tested:sprint-15
  Scenario: User registration
    Given registration page is open
    When user enters his/her details
    Then user is successful registered

  # TODO log bug in serenity -> @manual-test-evidence:[First_Screenshot](assets/bug.png) does not work

  @manual @regression
  @manual-result:Compromised
  @manual-last-tested:sprint-15
  Scenario: User orders a product
    Given shopping page is open
    When user enters his/her details
    Then user is successfully registered

  @manual @regression
  Scenario: User writes to other user
    Given chat page is open
    When John writes to Emily "hello"
    Then Emily receives John message

  @manual @regression
  Scenario: User adds socks to wish list
    Given shopping page is open
    When user adds a pair of socks to his wish list
    Then the pair of sock are added to user wish list