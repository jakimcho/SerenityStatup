Feature: Dashboard

  As a registered user I want to be able to create dashboards....

  Background:
    Given a user has logged in:
      | username | password      |
      | lbandrov | ASMLlyubo2023 |

  Scenario: Successful Dashboard creation
    When the user starts creating new dashboard:
      | name           | description     |
      | auto_dashboard | automation test |
    And the user chooses NXE machines:
      | 62281 |
    And the user adds "KPI" dashboard parameters:
      | MEAN_Amp_RM20_Temp |
    And the user saves the dashboard
    Then the dashboard is created


  Scenario: Successful registration
    Given a user is on "Registration" page
    When the user complete the registration form:
      | first_name | sir_name | email               | password  | confirm_password | birth_date |
      | Ivan       | Ivanov   | ivan.ivano@some.dom | A2s$ma!xf | A2s$ma!xf        | 05/12/1993 |
    Then the user is successfully registered