package net.jakim.testing.steps.definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.jakim.testing.entities.User;
import net.jakim.testing.uicomponents.RegistrationForm;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistrationSteps {
    @When("he completes the registration form with his date:")
    public void heCompletesTheRegistrationFormWithHisDate(User user) {
        when(theActorInTheSpotlight()).wasAbleTo(Enter.theValue(user.getFirstName())
                .into(RegistrationForm.FIRST_NAME_FIELD));

        and(theActorInTheSpotlight()).wasAbleTo(Enter.theValue(user.getSurName())
                .into(RegistrationForm.SUR_NAME_FIELD));

        and(theActorInTheSpotlight()).wasAbleTo(Enter.theValue(user.getEmail())
                .into(RegistrationForm.EMAIL_FIELD));

        and(theActorInTheSpotlight()).wasAbleTo(Enter.theValue(user.getPassword())
                .into(RegistrationForm.PASSWORD_FIELD));

        and(theActorInTheSpotlight()).wasAbleTo(Enter.theValue(user.getCity())
                .into(RegistrationForm.CITY_FIELD));

        and(theActorInTheSpotlight()).wasAbleTo(Enter.theValue(user.getCountry())
                .into(RegistrationForm.COUNTRY_FIELD));


        and(theActorInTheSpotlight()).attemptsTo(Click.on((RegistrationForm.REGISTERED_BUTTON)));
    }

    @Then("registration is successful")
    public void registrationIsSuccessful() {
    }
}
