Feature: Log in the system

  As a user with created account
  I want to be able to log in the system

  Alternative: If credentials are incorrect than system should warn the user


  Scenario: Successful Login
    Given a user has started the application
    When the user logs in with credentials:
      | username | password      |
      | lbandrov | ASMLlyubo2023 |
    Then system lets in the user