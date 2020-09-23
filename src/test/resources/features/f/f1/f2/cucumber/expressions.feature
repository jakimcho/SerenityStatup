Feature: Cucumber Expression

  Cucumber uses expressions to link a Gherkin Step to a Step Definition. You can use Regular Expressions or Cucumber Expressions.

  Cucumber Expressions offer similar functionality to Regular Expressions, with a syntax that is more human to read and write. Cucumber Expressions are also extensible with parameter types.

  Scenario: Alternative Text with John
    Given John has started the app
    When he adds 5 elements to his cart
    And he process the order
    Then the order is processed successfully

  Scenario: Alternative Text with Annie
    Given Annie has started the app
    When she adds 5 items to her cart
    And she process the order
    Then the order is processed successfully

  Scenario: Optional Text with Pronoun John
    Given John has entered the app
    When he lists the first 5 articles
    Then only those news are presented

  Scenario: Optional Text with Pronoun Annie
    Given Merry Jane has entered the app
    When she lists the first 5 articles
    Then only those news are presented

  Scenario: Optional Text with Cucumber 2 Annie
    When a person knows what is his problem
    Then only Valery Bojinov knows what is his own problem