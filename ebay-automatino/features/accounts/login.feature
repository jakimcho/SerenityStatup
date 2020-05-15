Feature: Login

  @debug
  Scenario: Unsuccessful user Login
    Given user has open site main page
    When user logs in with:
      | username          | password  |
      | ivancho@gmail.com | passwd123 |
    Then user should see error message:
    """
    To keep eBay a safe place to buy and sell, we will occasionally ask you to verify yourself. This helps us to block unauthorized users from entering our site.
    """