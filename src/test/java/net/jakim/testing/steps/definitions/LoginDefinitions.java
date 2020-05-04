package net.jakim.testing.steps.definitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.jakim.testing.pages.MainPage;
import net.jakim.testing.steps.libraries.LoginActions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static net.jakim.testing.pages.LoginForm.*;
import static net.jakim.testing.pages.MainPage.LOGIN_MENU;

@Slf4j
public class LoginDefinitions
{
    @Steps
    private LoginActions user;

    private MainPage mainPage;

    @Given ( "user is on the login screen" )
    @Screenshots(disabled=true)
    public void userIsOnTheLoginScreen( )
    {
        log.info("Inside userIsOnTheLoginScreen() method");
        mainPage.waitForWebContextAvailability( );
        mainPage.switchToWebViewContext( );
        WebElementFacade el = mainPage.find( LOGIN_MENU );
        el.waitUntilClickable();
        el.click();
        mainPage.switchToNativeContext();
        //user.tapsOn( LOGIN_MENU );
        log.info("Exiting userIsOnTheLoginScreen() method");
    }

    @When ( "user logs in with his credentials:" )
    @Screenshots(disabled=true)
    public void userLogsInWithHisCredentials( Map<String, String> credentials )
    {
        mainPage.waitForWebContextAvailability( );
        mainPage.switchToWebViewContext( );
        user.entersTextInField( credentials.get( "username" ),
                                USERNAME_FIELD );
        user.entersTextInField( credentials.get( "password" ),
                                PASSWORD_FIELD );
        user.tapsOn( LOGIN_BUTTON );
        mainPage.switchToNativeContext();
    }

    @Then ( "something awesome should happen" )
    @Screenshots(disabled=true)
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
Свилен и краси
Диляна и дея