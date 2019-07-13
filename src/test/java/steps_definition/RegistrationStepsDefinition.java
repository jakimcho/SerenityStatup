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
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class RegistrationStepsDefinition
{

    private User user;

    @When( "the user starts creating new account:" )
    public void theUserCompletesForm( @Transpose Map<String, String> dataTable )
    {
        user = new User( );
        user.setFirstName( dataTable.get( "firstName" ) );
        user.setLastName( dataTable.get( "lastName" ) );
        user.setEmail( dataTable.get( "email" ) );
        user.setPassword( dataTable.get( "password" ) );

        theActorInTheSpotlight( ).attemptsTo( StartsCreatingAccount.withEmail( user.getEmail( ) ),
                                              InRegistrationFrom.entersUserInfo( user ) );
    }

    @When( "fills in his address in the form:" )
    public void fillsInHisAddressInTheForm( @Transpose Map<String, String> dataTable )
    {
        Address address;
        if( dataTable.get( "lastName" ) == null && dataTable.get( "firstName" ) == null )
        {
            address = new Address( user );
        } else
        {
            address = new Address( );
            address.setFirstName( dataTable.get( "firstName" ) );
            address.setFirstName( dataTable.get( "lastName" ) );
        }

        address.setCompany( dataTable.get( "company" ) );
        address.setAddress( dataTable.get( "address" ) );
        address.setCity( dataTable.get( "city" ) );
        address.setCountry( dataTable.get( "country" ) );
        address.setState( dataTable.get( "state" ) );
        address.setZip( dataTable.get( "zip" ) );
        address.setMobilePhone( dataTable.get( "mobilePhone" ) );
        address.setAddressAlias( dataTable.get( "addressAlias" ) );

        user.setAddress( address );
        theActorInTheSpotlight( ).attemptsTo( InRegistrationFrom.entersAddressInfo( user.getAddress( ) ) );
    }

    @When( "submits the form" )
    public void submitsTheForm( )
    {
        theActorInTheSpotlight( ).attemptsTo( InRegistrationFrom.submitsForm( ) );
    }

    @Then( "he is successful registered in the system" )
    public void heIsSuccessfulRegisteredInTheSystem( )
    throws
            InterruptedException
    {
        Thread.sleep( 2000 );
        EnvironmentVariables ev = SystemEnvironmentVariables.createEnvironmentVariables( );
        String accountPageURL = EnvironmentSpecificConfiguration.from( ev )
                                                                .getProperty( "my-account.page" );

        theActorInTheSpotlight( ).should( seeThat( CurrentPage.url( ),
                                                   is( accountPageURL ) ) );
    }
}
