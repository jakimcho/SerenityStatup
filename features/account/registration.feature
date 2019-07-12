Feature: Account Registration

  As a future site client
  I want to have a way to register myself
  In order to have a system account

  Background:
    Given a not register user is on the "Registration" page

  Scenario: Successful account creation
    When the user starts creating new account:
      | title | name | lastname | email            | password | dateOfBirth |
      | mr    | Joro | ivanov   | j.ivanov@fds.csm | dasdas   | 11/11/1983  |
    And fills in his address in the form:
      | title | name | lastname | email            | password | dateOfBirth |
      | mr    | Joro | ivanov   | j.ivanov@fds.csm | dasdas   | 11/11/1983  |
    And submits the form
    Then he is successful registered in the system