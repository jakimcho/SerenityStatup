package net.jakim.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static java.time.Duration.ofSeconds;

public class RegistrationForm {

    public final static Target FIRST_NAME_FIELD = Target.the("First name field")
            .located(By.name("first_name"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target SUR_NAME_FIELD = Target.the("Sur name field")
            .located(By.name("sir_name"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target EMAIL_FIELD = Target.the("Email")
            .located(By.name("email"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target PASSWORD_FIELD = Target.the("Password field")
            .located(By.name("pass"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target COUNTRY_FIELD = Target.the("Country field")
            .located(By.name("country"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target CITY_FIELD = Target.the("City field")
            .located(By.name("city"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target TERMS_CONDITIONS_CHECKBOX = Target.the("Terms And Conditions Checkbox")
            .located(By.id("TOS"))
            .waitingForNoMoreThan(ofSeconds(2));

    public final static Target REGISTER_BUTTON = Target.the("Register Button")
            .located(By.name("signup"))
            .waitingForNoMoreThan(ofSeconds(2));
}
