package net.jakim.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registration
{
    public static Target EMAIL_FOR_REGISTRATION = Target.the( "'Email address' field for registration form" )
                                                        .located( By.name( "email_create" ) );

    public static Target CREATE_ACCOUNT_BUTTON = Target.the( "'Create an account' button" )
                                                       .locatedBy( "#SubmitCreate" );
    public static Target FIRST_NAME_FIELD = Target.the( "'First name' field from the reg. form" )
                                                  .located( By.name( "customer_firstname" ) );
}
