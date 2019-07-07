package steps_definition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps_libraries.DemoAdminSystem;
import steps_libraries.DemoNavigations;
import steps_libraries.DemoShopper;

public class DemoDefinitions
{

    @Steps
    DemoNavigations registeredUser;

    @Steps
    DemoShopper shopper;

    @Steps
    DemoAdminSystem systemAdmin;


    @When( "^the user buys (\\d+) items with part name \"([^\"]*)\"$" )
    public void theUserBuysItemsWithPartName( int itemsNumber,
                                              String partName )
    {
        shopper.searchesFor( partName )
               .selectsItems( itemsNumber )
               .addsSelectedItemsToTheBasket()
               .and()
               .placesOrder();
    }

    @Then( "^the user's order is placed successfully$" )
    public void theUserSOrderIsPlacedSuccessfully()
    {
        shopper.seesSuccessfulMessage("Successful Order!!!").and().seesHisAccountBallanceHasUpdated();
    }

    @Given( "^a registered user has open \"([^\"]*)\" page$" )
    @And("^the user has open \"([^\"]*)\" page$")
    public void aRegisteredUserHasOpenPage( String page )
    {
        registeredUser.logsIn()
                      .and()
                      .opensPage( page );
    }

    @Given( "^a registered user with an order$" )
    public void aRegisteredUserWithAnOrder()
    {
        registeredUser.ordersWithRest();
    }

    @When( "^the user refund his order due to$" )
    public void theUserRefundHisOrderDueTo(String message)
    {
        shopper.refundsOrder(message);
    }


    @Then( "^the system created refunding ticket$" )
    public void theSystemCreatedRefundingTicket()
    {
        systemAdmin.seesNewRefundTicet();
    }

    @Then( "^the refunding ticket contains customer message$" )
    public void theRefundingTicketContainsCustomerMessage()
    {
        systemAdmin.readsTheRefundTicket();
    }

}
