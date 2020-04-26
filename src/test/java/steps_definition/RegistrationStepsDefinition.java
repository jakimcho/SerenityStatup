package steps_definition;

import cucumber.api.Transpose;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.jakim.entities.Address;
import net.jakim.entities.User;
import net.jakim.screenplay.questions.CurrentPage;
import net.jakim.screenplay.tasks.InRegistrationFrom;
import net.jakim.screenplay.tasks.StartsCreatingAccount;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utils.EntitiesBuildersFactory;

import java.util.Map;

import static net.jakim.screenplay.user_interface.Registration.CREATE_ACCOUNT_BUTTON;
import static net.jakim.screenplay.user_interface.Registration.CREATE_ACCOUNT_BUTTON_WRONG;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.is;

public class RegistrationStepsDefinition
{

    private User user;

    @When ( "the user starts creating new account:" )
    public void theUserCompletesForm( @Transpose Map<String, String> rawData )
    {
        user = EntitiesBuildersFactory
            .getUserBuilder( )
            .fromMap( rawData )
            .build( );
        try
        {
            theActorInTheSpotlight( ).should( seeThat( the( CREATE_ACCOUNT_BUTTON ),
                                                       isVisible( ) ).orComplainWith( JRException.class,
                                                                                      "Nema go" ) );
            WebElementFacade ef = BrowseTheWeb.as( theActorInTheSpotlight( ) ).find( By.id( "SubmitCreate" ) );
            ef.click();

        }
        catch ( ElementShouldBeEnabledException e )
        {
            System.out.println( "Got the exception" );
            e.printStackTrace( );
        } catch ( StaleElementReferenceException e ){
            System.out.println( "Got the stale exception" );
            e.printStackTrace( );
        }

        theActorInTheSpotlight( ).attemptsTo( Click.on( CREATE_ACCOUNT_BUTTON ) );
    }

    @When ( "fills in his address in the form:" )
    public void fillsInHisAddressInTheForm( @Transpose Map<String, String> rawData )
    {
        Address address = EntitiesBuildersFactory
            .getAddressBuilder( )
            .fromMap( rawData )
            .build( );
        if ( address.getFirstName( ) == null && address.getFirstName( ) == null )
        {
            address.setFirstName( user.getFirstName( ) );
            address.setLastName( user.getLastName( ) );
        }

        user.setAddress( address );
        theActorInTheSpotlight( ).attemptsTo( InRegistrationFrom.entersAddressInfo( user.getAddress( ) ) );
    }

    @When ( "submits the form" )
    public void submitsTheForm( )
    {
        theActorInTheSpotlight( ).attemptsTo( InRegistrationFrom.submitsForm( ) );
    }

    @Then ( "he is successful registered in the system" )
    public void heIsSuccessfullyRegisteredInTheSystem( )
        throws
        InterruptedException
    {
        Thread.sleep( 2000 );
        EnvironmentVariables ev = SystemEnvironmentVariables.createEnvironmentVariables( );
        String accountPageURL = EnvironmentSpecificConfiguration
            .from( ev )
            .getProperty( "my-account.page" );

        theActorInTheSpotlight( ).should( seeThat( CurrentPage.url( ),
                                                   is( accountPageURL ) ) );
    }
}
