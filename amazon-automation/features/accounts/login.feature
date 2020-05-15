Feature: Login

  @debug
  Scenario: Unsuccessful user Login
    Given user has open site main page
    When user logs in with:
      | username       | password  |
      | ivancho@abv.bg | passwd123 |
    Then user should see error message:
    """
    To better protect you, please re-enter your password and then enter the characters as they are shown in the image below.
    """