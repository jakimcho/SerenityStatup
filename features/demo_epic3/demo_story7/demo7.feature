Feature: BDD Demo automation with Serenity 2

  As an automation engineer
  I want to exercise Serenity With Cucumber 4 capabilities
  In order to have some good show cases
  ![It is Me, The Devil!](assets/the_red_guy.png)

  @Priority:1 @smoke @purchase @shopping-basket @catalog-page
  Scenario: Order items from the store 1237
    Given a registered user has open "Catalog" page
    When the user buys 3 items with part name "rasp"
    Then the user's order is placed successfully


  @Priority:3 @regression
  Scenario: Refund an order 1237
    Given a registered user with an order
    And the user has open "My Orders" page
    When the user refund his order due to
    """
      Dear support,

    I want my money back, because the order does not meet
    Catalog description!
    """

    Then the system created refunding ticket
    And the refunding ticket contains customer message