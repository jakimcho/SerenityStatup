package steps_definition;

import cucumber.api.Transpose;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps_libraries.TPMSUser;

import java.util.Map;

public class TPMSLoginStepsDefinition {

    @Steps
    TPMSUser joro;
    @Given("a user has started the application")
    public void aUserHasStartedTheApplication() {
        joro.opensTheApplication();
    }

    @When("the user logs in with credentials:")
    public void theUserLogsInWithCredentials(@Transpose Map<String, String> credentials) {
        joro.fillsLoginForm(credentials);
        joro.submitsLoginForm();

    }

    @Then("system lets in the user")
    public void systemLetsInTheUser() {
       joro.hasSuccessfullyLoggedIn();
    }
}
