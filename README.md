# JR Serenity Starter Projects

## Tanks to : [Serenity BDD](http://www.thucydides.info/#/)

## Summary

This project should surf as a bear minimum to start building an automation system.
The main target approach to follow is BDD with cucumber.

## Techs

- Serenity Framework 2.3.2 
- Selenium WebDriver
- Cucumber 6
- Spring integration
- Junit 4.13
- AssertJ

## Usage

### Handle data tables from gherkin scenarios

Each data table in gherkin that representing a unit shall be handle as follows:
 - define a Class representing the unit in the entities package.
 - define a Builder class that extends the AbstractEntitiesBuilder class for the created Entity class (see the already created Dashboard.class)
 - in the gherkin data tables define the table with column names equal to the Entity properties' names
 - in the steps definition files, convert these data tables like so:
    ```
        @Given("[some_pattern]")
        public void doSomething(@Transpose Мап<String, String> rawData){
            Entity e = EntityBuilderFactory.buildEntity().fromMap(rawData).build();
        }
    ```
  - in order to inject some randomization in the values use [5A] for 5 random upper-case alpha bet letters, [2a] for 2 random down-case alpha bet letters and [4d] for random 4 digits
  ```
    And user enters his details:
    | name | email           | password       | sirName |
    | Ivan | iv[4a]@dodo.com | [3d]![2A]$[5a] | Goranov |
  ```

## Useful Info
Before start building your awesome automation system based on this project, you may find useful to read the info from bellow links:

- [Serenity Reference Manual](http://thucydides.info/docs/serenity-staging/)
- [The Serenity BDD Book](https://serenity-bdd.github.io/theserenitybook/latest/index.html)  
