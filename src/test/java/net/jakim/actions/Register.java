package net.jakim.actions;

import net.jakim.elements.RegistrationForm;
import net.jakim.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.CheckCheckbox;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.jakim.elements.RegistrationForm.TERMS_CONDITIONS_CHECKBOX;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {
    private User user;

    public Register(User user) {
        this.user = user;
    }

    public static Register with(User user) {
        return instrumented(Register.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(user.getFirstName()).into(RegistrationForm.FIRST_NAME_FIELD),
                Enter.theValue(user.getSurName()).into(RegistrationForm.SUR_NAME_FIELD),
                Enter.theValue(user.getEmail()).into(RegistrationForm.EMAIL_FIELD),
                Enter.theValue(user.getPassword()).into(RegistrationForm.PASSWORD_FIELD),
                Enter.theValue(user.getCountry()).into(RegistrationForm.COUNTRY_FIELD),
                Enter.theValue(user.getCity()).into(RegistrationForm.CITY_FIELD),
                CheckCheckbox.of(TERMS_CONDITIONS_CHECKBOX),
                Click.on(RegistrationForm.REGISTER_BUTTON));
    }
}