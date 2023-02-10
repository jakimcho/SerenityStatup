package net.jakim.test_runners;

import net.jakim.actions.Register;
import net.jakim.elements.HomePage;
import net.jakim.models.User;
import net.jakim.utils.UserFactory;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SerenityJUnit5Extension.class)
public class RegistrationTest1 {

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
        when(indiana).attemptsTo(
                Open.browserOn().thePageNamed("registration.page"),
                Register.with(validUser)
        );

        String userFullName = validUser.getFirstName() + " " + validUser.getSurName();
        then(indiana).can(
                seeThat(Text.of(HomePage.JUMBOTRON_HEADING),
                        containsString(userFullName)));
    }
}
