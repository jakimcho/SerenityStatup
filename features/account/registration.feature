Feature: Account Registration

  As a future site client
  I want to have a way to register myself
  In order to have a system account

  Background:
    Given a not register user is on the "Registration" page


  @jr:demo
  Scenario: Successful account creation
    When the user starts creating new account:
      | title | firstName | lastName | email        | password |
      | mr    | Joro      | ivanov   | j.auto[4A]@[4a].csm | dasdas   |
    And fills in his address in the form:
      | company | address        | city  | state   | country       | zip   | mobilePhone | addressAlias |
      | Gogo    | str Lisitsa 51 | Sofia | Alabama | United States | 15025 | 432423423   | homeAddr     |
    And submits the form
    Then he is successful registered in the system