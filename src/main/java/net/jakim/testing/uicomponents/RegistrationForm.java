package net.jakim.testing.uicomponents;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public interface RegistrationForm {

    Target FIRST_NAME_FIELD = Target.the("First name field")
            .located(By.name("first_name"));

    Target SUR_NAME_FIELD = Target.the("Sur name field")
            .located(By.name("sir_name"));

    Target EMAIL_FIELD = Target.the("First name field")
            .located(By.name("email"));

    Target PASSWORD_FIELD = Target.the("First name field")
            .located(By.name("pass"));

    Target COUNTRY_FIELD = Target.the("Country name field")
            .located(By.name("country"));

    Target CITY_FIELD = Target.the("City field")
            .located(By.name("city"));

    Target REGISTERED_BUTTON = Target.the("Register button")
            .located(By.name("signup"));

}
