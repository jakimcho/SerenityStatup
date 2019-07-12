package steps_definition;

import cucumber.api.Transpose;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.jakim.screenplay.tasks.FillsInUserData;
import net.jakim.screenplay.tasks.StartsCreatingAccount;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistrationStepsDefinition
{

    @When( "the user starts creating new account:" )
    public void theUserCompletesForm( @Transpose Map<String, String> dataTable )
    {
        theActorInTheSpotlight( ).attemptsTo( StartsCreatingAccount.withEmail( dataTable.get( "email" ) ),
                                              FillsInUserData.inCreateAnAccountForm( dataTable ) );
    }

    @Then( "he is successful registered in the system" )
    public void heIsSuccessfulRegisteredInTheSystem( )
    {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException( );
    }

}
