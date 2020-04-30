Feature: Login Feature

  Scenario: User Login
    Given user is on the login screen
    When user logs in with his credentials:
      | username | password  |
      | gosho    | Passwd123 |
    Then something awesome should happen