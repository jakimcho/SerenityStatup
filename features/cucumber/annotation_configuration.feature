Feature: Annotation Configuration

  Cucumber Expressions were originally introduced in Cucumber-JVM 3.0.0.
  With it came the ability to register parameter- and data table-types by implementing the TypeRegistryConfigurer.

  The TypeRegistryConfigurer however is not part of the glue.
  This made it impossible to access the test context.
  With cucumber-java this is now possible by using the @ParameterType, @DataTableType and @DocStringType annotations.
  This allows parameter-, data table- and docstring types to be mapped to objects which can only be created inside the test context.

  Scenario: Annotating Catalog

  Given the awesome catalog
  When a user places the awestruck eels in his basket
  Then you will be shocked at what happened next