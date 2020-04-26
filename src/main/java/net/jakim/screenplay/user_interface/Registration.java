package net.jakim.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Registration
{
    public static Target EMAIL_FOR_REGISTRATION = Target.the( "'Email address' field for registration form" )
                                                        .located( By.name( "email_create" ) );

    public static Target CREATE_ACCOUNT_BUTTON = Target.the( "'Create an account' button" )
                                                       .locatedBy( "#SubmitCreate" );
    public static Target CREATE_ACCOUNT_BUTTON_WRONG = Target.the( "'Create an account' button" )
        .locatedBy( "#SubmitCreateq" );
    public static Target FIRST_NAME_FIELD = Target.the( "'First name' field from the reg. form" )
                                                  .located( By.name( "customer_firstname" ) );

    public static Target CUSTOMER_FIRST_NAME_FIELD
            = Target.the( "customer 'First name' field in the registration form" )
                    .located( By.name( "customer_firstname" ) );

    public static Target CUSTOMER_LAST_NAME_FIELD = Target.the( "customer 'Last name' field in the registration form" )
                                                          .located( By.name( "customer_lastname" ) );

    public static Target CUSTOMER_EMAIL_FIELD = Target.the( "customer 'Email' field in the registration form" )
                                                      .located( By.name( "email" ) );

    public static Target CUSTOMER_PASSWORD_FIELD = Target.the( "customer 'Password' field in the registration form" )
                                                         .located( By.name( "passwd" ) );

    public static Target CUSTOMER_BIRTHDATE_FIELD = Target.the( "customer 'Last name' field in the registration form" )
                                                          .located( By.xpath( "//div[contains(@class,'form-group') and ./label[text()='Date of Birth']]" ) );

    public static Target ADDRESS_FIRST_NAME_FIELD = Target.the( "address 'First name' field in the registration form" )
                                                          .located( By.name( "firstname" ) );

    public static Target ADDRESS_LAST_NAME_FIELD = Target.the( "address 'Last name' field in the registration form" )
                                                         .located( By.name( "lastname" ) );

    public static Target COMPANY_FIELD = Target.the( "'Company' field in the registration form" )
                                               .located( By.name( "company" ) );

    public static Target ADDRESS_FIELD = Target.the( "'Address' field in the registration form" )
                                               .located( By.name( "address1" ) );

    public static Target CITY_FIELD = Target.the( "'City' field in the registration form" )
                                            .located( By.name( "city" ) );

    public static Target STATE_FIELD = Target.the( "'State' field in the registration form" )
                                             .located( By.name( "id_state" ) );

    public static Target ZIP_FIELD = Target.the( "'ZIP/Postal code' field in the registration form" )
                                           .located( By.name( "postcode" ) );

    public static Target COUNTRY_FIELD = Target.the( "'Country' field in the registration form" )
                                               .located( By.name( "id_country" ) );

    public static Target MOBILE_PHONE_FIELD = Target.the( "'Mobile phone' field in the registration form" )
                                                    .located( By.name( "phone_mobile" ) );

    public static Target ADDRESS_ALIAS_FIELD = Target.the( "address 'Alias' field in the registration form" )
                                                     .located( By.name( "alias" ) );

    public static Target REGISTER_BUTTON = Target.the( "account 'Register' button" )
                                                 .located( By.id( "submitAccount" ) );
}
