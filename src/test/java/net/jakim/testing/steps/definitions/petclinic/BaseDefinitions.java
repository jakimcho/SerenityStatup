package net.jakim.testing.steps.definitions.petclinic;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jakim.testing.steps.libraries.BaseWebActions;
import net.thucydides.core.annotations.Steps;

import static net.jakim.testing.pages.BasePage.PAGE_HEADING_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

public class BaseDefinitions {

    @Steps
    private BaseWebActions webUser;

    @When("(.*) opens the {page} page")
    public void jilOpensTheHomePage(String page) {
        webUser.opensPage(page);
    }

    @Then("She/He sees {string} message on the page")
    public void sheSeesMessage(String expectedMessage) {
        assertThat(webUser.seesTextFrom(PAGE_HEADING_MESSAGE)).isEqualTo(expectedMessage);
    }
}
