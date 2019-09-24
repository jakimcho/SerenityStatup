package steps_definition;

import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.jakim.entities.Address;
import net.jakim.entities.User;
import net.thucydides.core.annotations.Steps;
import steps_libraries.CommonUserSteps;
import utils.EntitiesBuildersFactory;

import java.util.Map;

public class AccountRegistrationStepsDefinition
{

    @Steps
    private CommonUserSteps commonUser;

    @Given( "a new user is on the {string} page" )
    public void aNewUserIsOnThePage( String pageName )
    {
        switch( pageName )
        {
            case "Registration":
                commonUser.opensRegistrationPage( );
        }
    }

    @When( "the user starts creating new account:" )
    public void theUserStartsCreatingNewAccount( @Transpose Map<String, String>
                                                         userPersonalProperties )
    {
        User user = EntitiesBuildersFactory.getUserBuilder( )
                                           .fromMap( userPersonalProperties )
                                           .build( );
        // Fills in email address that will be used further in the registration process
        // and clicks create an account
        commonUser.startsAccountCreation( user );
        commonUser.fillsInPersonalInformation( user );
    }

    @When( "fills in his address in the form:" )
    public void fillsInHisAddressInTheForm( @Transpose Map<String, String>
                                                    userAddress )
    {
        Address address = EntitiesBuildersFactory.getAddressBuilder( )
                                                 .fromMap( userAddress )
                                                 .build( );
        commonUser.fillsInAddressInformation( address );
    }

    @When( "submits the form" )
    public void submitsTheForm( )
    {
        commonUser.clicksOnRegister( );
    }

    @Then( "he is successful registered in the system" )
    public void heIsSuccessfulRegisteredInTheSystem( )
    {
        commonUser.hasRegisteredSuccessfully( );

    }
}
