package net.jakim.testing.steps.definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jakim.testing.steps.libaryies.CommonSteps;
import net.jakim.testing.wab_ui.Login;
import net.jakim.testing.wab_ui.Menu;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LoginDefinitions
{
    @Steps
    private CommonSteps user;

    @Given ( "user has open site main page" )
    public void openMainPage( )
    {
        user.opensPage( "home.page" );
    }

    @When ( "user logs in with:" )
    public void openMainPage( @Transpose Map<String, String> credentials )
    {
        user.clicksOn( Menu.SIGN_IN_BUTTON );
        user.typesTextIntoField( credentials.get( "username" ),
                                 Login.USERNAME_FIELD );
        user.clicksOn( Login.CONTINUE_BUTTON );
        user.typesTextIntoField( credentials.get( "password" ),
                                 Login.PASSWORD_FIELD );
        user.clicksOn( Login.SUBMIT_BUTTON );
    }

    @Then ( "user should see error message:" )
    public void openMainPage( String expectedErrorMessage )
    {
        assertThat( user.readsAlertMessage( ),
                    containsString( expectedErrorMessage ) );
    }

}
