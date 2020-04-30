package net.jakim.testing.steps.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.jakim.testing.steps.libraries.LoginActions;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static net.jakim.testing.pages.LoginForm.*;
import static net.jakim.testing.pages.MainPage.LOGIN_MENU;

@Log
public class LoginDefinitions
{
    @Steps
    private LoginActions user;

    @Given ( "user is on the login screen" )
    public void userIsOnTheLoginScreen( )
    {
        log.info("Inside userIsOnTheLoginScreen() method");
        user.tapsOn( LOGIN_MENU );
        log.info("Exiting userIsOnTheLoginScreen() method");
    }

    @When ( "user logs in with his credentials:" )
    public void userLogsInWithHisCredentials( Map<String, String> credentials )
    {
        user.entersTextInField( credentials.get( "username" ),
                                USERNAME_FIELD );
        user.entersTextInField( credentials.get( "password" ),
                                PASSWORD_FIELD );
        user.tapsOn( LOGIN_BUTTON );
    }

    @Then ( "something awesome should happen" )
    public void somethingAwesomeShouldHappen( )
    {
    }

    @Before
    public void switchContext( )
    {
        user.starts( );
        user.waitsForEnvironmentsPromptScreen( );
        user.selectsTheTargetEnvironment( );
    }
}
