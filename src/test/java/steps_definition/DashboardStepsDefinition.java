package steps_definition;

import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps_libraries.TPMSDashboardUser;
import steps_libraries.TPMSUser;

import java.util.List;
import java.util.Map;

public class DashboardStepsDefinition {

    @Steps
    TPMSUser registeredUser;

    @Steps
    TPMSDashboardUser dashboardUser;

    @Given("a user has logged in:")
    public void aUserHasLoggedIn(@Transpose Map<String, String> credentials) {
        registeredUser.opensTheApplication();
        registeredUser.fillsLoginForm(credentials);
        registeredUser.submitsLoginForm();
        registeredUser.hasSuccessfullyLoggedIn();
    }

    @When("the user starts creating new dashboard:")
    public void theUserStartsCreatingNewDashboard(@Transpose Map<String, String> dashboardDescription) {
        registeredUser.opensPage("Monitoring");
        dashboardUser.startsCreatingDashboard(dashboardDescription);
    }

    @When("the user chooses NXE machines:")
    public void theUserChoosesNXEMachines(List<String> machines) {
        dashboardUser.addsMachinesToTheDashboard(machines);
    }

    @When("the user adds {string} dashboard parameters:")
    public void theUserAddsDashboardParameters(String paramType, List<String> paramsName ) {
        dashboardUser.addsParametersToTheDashboard(paramType, paramsName);
    }

    @When("the user saves the dashboard")
    public void theUserSavesTheDashboard() {
        dashboardUser.savesTheDashboard();
    }
}
