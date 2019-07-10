package net.jakim.screenplay.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.EnterValue;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static net.jakim.screenplay.user_interface.Registration.FIRST_NAME_FIELD;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillsInUserData
        implements Task
{
    private Map<String, String> userData;

    public FillsInUserData( Map<String, String> userData )
    {
        this.userData = userData;
    }

    public static FillsInUserData inCreateAnAccountForm( Map<String, String> userData )
    {
        return instrumented( FillsInUserData.class,
                             userData );
    }

    @Override
    @Step( "{0} fills his personal details into the registration form" )
    public <T extends Actor> void performAs( T actor )
    {
        actor.attemptsTo( Enter.theValue( userData.get( "name" ) )
                               .into( FIRST_NAME_FIELD ) );
    }
}
