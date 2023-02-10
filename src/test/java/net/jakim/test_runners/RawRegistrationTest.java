package net.jakim.test_runners;

import net.jakim.elements.HomePage;
import net.jakim.elements.RegistrationForm;
import net.jakim.models.User;
import net.jakim.utils.UserFactory;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.jakim.elements.RegistrationForm.TERMS_CONDITIONS_CHECKBOX;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class RawRegistrationTest {

    @Managed
    WebDriver driver;

    private Actor indiana;

    @BeforeEach
    public void prepareActor() {
        indiana = Actor.named("Indiana Jones")
                .whoCan(BrowseTheWeb.with(driver));
    }

    @Test
    void validRegistration() {
        User validUser = UserFactory.getAValidUser();
        when(indiana).attemptsTo(Open.browserOn().thePageNamed("registration.page"),
                Enter.theValue(validUser.getFirstName()).into(RegistrationForm.FIRST_NAME_FIELD),
                Enter.theValue(validUser.getSurName()).into(RegistrationForm.SUR_NAME_FIELD),
                Enter.theValue(validUser.getEmail()).into(RegistrationForm.EMAIL_FIELD),
                Enter.theValue(validUser.getCountry()).into(RegistrationForm.PASSWORD_FIELD),
                Enter.theValue(validUser.getCountry()).into(RegistrationForm.COUNTRY_FIELD),
                Enter.theValue(validUser.getCity()).into(RegistrationForm.CITY_FIELD),
                CheckCheckbox.of(TERMS_CONDITIONS_CHECKBOX),
                Click.on(RegistrationForm.REGISTER_BUTTON)
        );

        String jumbotronHeading = when(indiana).asksFor(
                Text.of(HomePage.JUMBOTRON_HEADING));

        String userFullName = validUser.getFirstName() + " " + validUser.getSurName();

        assertThat(jumbotronHeading, containsString("Hello"));
        assertThat(jumbotronHeading, containsString(userFullName));

        // or

        then(indiana).can(
                seeThat(Text.of(HomePage.JUMBOTRON_HEADING),
                        containsString(userFullName)));

    }
}
