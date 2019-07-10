package net.jakim.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.jakim.screenplay.user_interface.Registration.CREATE_ACCOUNT_BUTTON;
import static net.jakim.screenplay.user_interface.Registration.EMAIL_FOR_REGISTRATION;

public class StartsCreatingAccount
{
    public static Task withEmail( String email )
    {
        return Task.where( "{0} starts creating an account",
                           Enter.theValue( email )
                                .into( EMAIL_FOR_REGISTRATION ),
                           Click.on( CREATE_ACCOUNT_BUTTON )
                         );
    }

}
