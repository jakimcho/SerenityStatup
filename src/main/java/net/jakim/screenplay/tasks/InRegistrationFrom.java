package net.jakim.screenplay.tasks;


import net.jakim.entities.User;
import net.jakim.screenplay.user_interface.Registration;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class InRegistrationFrom
{


    public static Task enterUserInfo( final User user )
    {
        return Task.where( "fills in user info #user",
                           Enter.theValue( user.getFirstName( ) )
                                .into( Registration.CUSTOMER_FIRST_NAME_FIELD ),
                           Enter.theValue( user.getLastName( ) )
                                .into( Registration.CUSTOMER_LAST_NAME_FIELD ),
                           Enter.theValue( user.getPassword( ) )
                                .into( Registration.CUSTOMER_PASSWORD_FIELD ),
                           Enter.theValue( user.getEmail( ) )
                                .into( Registration.CUSTOMER_EMAIL_FIELD ) );
    }


}
