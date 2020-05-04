package net.jakim.testing.steps.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CucumberExpressions
{
    @Given ( "John/Annie has started the app" )
    public void startTheApp( )
    {
        log.info( "John or Annie has started the app" );
    }

    @When ( "he/she adds {int} elements/items/stocks to his/her cart" )
    public void addItemsToCart( Integer itemsNumber )
    {
        log.info( "He or she adds {} elements or items or stocks to his or her cart",
                  itemsNumber );
    }

    @When ( "he/she process the order" )
    public void processOrder( )
    {
        log.info( "He or she process the order" );
    }

    @Then ( "the order is processed successfully" )
    public void verifySuccessfulOrder( )
    {
        log.info( "the order is processed successfully" );
    }

    @Given ( "(.*) has entered the app" )
    public void enterTheApp( String s )
    {
        log.info( "John or Merry Jane has entered the app {}" );
    }

    @When ( "(s)he lists the first {int} article(s)" )
    public void processOrder( Integer newsNumber )
    {
        log.info( "She or he lists the first {} article(s)",
                  newsNumber );
    }

    @Then ( "only those news are presented" )
    public void verifyShownArticles( )
    {
        log.info( "only those news are presented" );
    }

}
