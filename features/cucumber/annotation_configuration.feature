Feature: Annotation Configuration

  __Cucumber Custom Parameters__

  Cucumber Expressions were originally introduced in Cucumber-JVM 3.0.0.
  With it came the ability to register parameter- and data table-types by implementing the TypeRegistryConfigurer.

  The TypeRegistryConfigurer however is not part of the glue.
  This made it impossible to access the test context.
  With cucumber-java this is now possible by using the annotations:
  - @ParameterType
  - @DataTableType
  - @DocStringType

  This allows parameter-, data table- and docstring types to be mapped to objects which can only be created inside the test context.

  Scenario: ParameterType Annotation Configuration
    Given the awesome catalog
    When a user places the awestruck eels in his basket
    Then you will be shocked at what happened next

  Scenario: DataTableType Annotation Configuration
    When a user orders products:
      | name     | vendor | type  |
      | Milk     | Danone | dairy |
      | sausages | Tandem | meat  |
    Then order is placed successfully

  Scenario: DataTableType Annotation Cell Configuration
    When a user orders products by id:
      |   | name     | vendor | type  |
      | 2 | Milk     | Danone | dairy |
      | 4 | sausages | Tandem | meat  |
    Then order with ids is placed successfully

  Scenario: DataTableType Annotation Java Object Configuration
    When a user creates new account:
      | firstName | surName | age |
      | Georgi    | Ivanov  | 18  |
    Then the user account is created successfully