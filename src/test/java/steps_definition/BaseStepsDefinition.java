package steps_definition;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import net.jakim.screenplay.tasks.Start;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BaseStepsDefinition
{
    /*
        The code bellow gets params from serenity.conf file
        EnvironmentVariables sd = SystemEnvironmentVariables.createEnvironmentVariables( );
        String webserviceEndpoint = EnvironmentSpecificConfiguration.from( sd )
                                                                    .getProperty( "my.user" );
        System.out.println( "Env var: " + webserviceEndpoint );
    */

    @Before
    public void set_the_stage( )
    {
        OnStage.setTheStage( new OnlineCast( ) );
    }

    @Given( "a not register user is on the {string} page" )
    public void aNotRegisterUserIsOnThePage( String page )
    {
        theActorCalled( "Ivancho" ).wasAbleTo( Start.withPage( page ) );
    }

}
