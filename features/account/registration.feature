Feature: Account Registration

  As a future site client
  I want to have a way to register myself
  In order to have a system account

  Background:
    Given a new user is on the "Registration" page

  @jr:demo
  Scenario: Successful account creation
    When the user starts creating new account:
      | title | firstName | lastName | email                | password    |
      | mr    | Joro[3A]  | ivanov   | j.ivanov[5a]@fds.csm | dasdas[10d] |
    And fills in his address in the form:
      | firstName | lastName | company | address   | city     | state  | postalCode | country     | mobilePhone   | alias      |
      | Joro[3A]  | ivanov   | strypes | somewhere | someCity | Alaska | [5d]       | someCountry | somePhone[5d] | potato[3A] |
    And submits the form
    Then he is successful registered in the system
