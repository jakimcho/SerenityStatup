Feature: Registration

  Scenario: Successful Registration
    Given Ivan is on Registration page
    When he completes the registration form with his date:
      | firstName | surName | country  | city  | email       | password |
      | Ivan      | Ivanov  | Bulgaria | Sofia | ivv@dsf.com | dasdasda |
    Then registration is successful