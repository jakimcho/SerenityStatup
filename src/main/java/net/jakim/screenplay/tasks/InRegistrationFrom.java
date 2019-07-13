package net.jakim.screenplay.tasks;


import net.jakim.entities.Address;
import net.jakim.entities.User;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import java.util.ArrayList;
import java.util.List;

import static net.jakim.screenplay.user_interface.Registration.*;

public class InRegistrationFrom
{


    public static Task entersUserInfo( final User user )
    {
        return Task.where( "{0} fills in user info ",
                           ( completingFieldsFor( user ) ) );
    }

    public static Task entersAddressInfo( Address address )
    {
        return Task.where( "{0} fills in user address info ",
                           ( completingFieldsFor( address ) ) );
    }

    public static Performable submitsForm( )
    {
        return Task.where( "{0} submits the registration form",
                           ( Click.on( REGISTER_BUTTON ) ) );
    }

    /////////////////////// HELPERS ////////////////////////////////

    private static Performable[] completingFieldsFor( User user )
    {

        List<Performable> completingFields = new ArrayList<>( );

        if( user.getFirstName( ) != null )
        {
            completingFields.add( Enter.theValue( user.getFirstName( ) )
                                       .into( CUSTOMER_FIRST_NAME_FIELD ) );
        }

        if( user.getLastName( ) != null )
        {
            completingFields.add( Enter.theValue( user.getLastName( ) )
                                       .into( CUSTOMER_LAST_NAME_FIELD ) );
        }

        if( user.getPassword( ) != null )
        {
            completingFields.add( Enter.theValue( user.getPassword( ) )
                                       .into( CUSTOMER_PASSWORD_FIELD ) );
        }

        if( user.getEmail( ) != null )
        {
            completingFields.add( Enter.theValue( user.getEmail( ) )
                                       .into( CUSTOMER_EMAIL_FIELD ) );
        }

        if( user.getBirthDate( ) != null )
        {
            completingFields.add( Enter.theValue( user.getBirthDate( ) )
                                       .into( CUSTOMER_BIRTHDATE_FIELD ) );
        }

        Performable[] actions = completingFields.toArray( new Performable[completingFields.size( )] );
        return actions;
    }


    private static Performable[] completingFieldsFor( Address address )
    {

        List<Performable> completingFields = new ArrayList<>( );

        if( address.getFirstName( ) != null )
        {
            completingFields.add( Enter.theValue( address.getFirstName( ) )
                                       .into( ADDRESS_FIRST_NAME_FIELD ) );
        }

        if( address.getLastName( ) != null )
        {
            completingFields.add( Enter.theValue( address.getLastName( ) )
                                       .into( ADDRESS_LAST_NAME_FIELD ) );
        }

        if( address.getCompany( ) != null )
        {
            completingFields.add( Enter.theValue( address.getCompany( ) )
                                       .into( COMPANY_FIELD ) );
        }

        if( address.getAddress( ) != null )
        {
            completingFields.add( Enter.theValue( address.getAddress( ) )
                                       .into( ADDRESS_FIELD ) );
        }

        if( address.getCity( ) != null )
        {
            completingFields.add( Enter.theValue( address.getCity( ) )
                                       .into( CITY_FIELD ) );
        }

        if( address.getState( ) != null )
        {
            completingFields.add( SelectFromOptions.byVisibleText( address.getState( ) )
                                                   .from( STATE_FIELD ) );
        }

        if( address.getZip( ) != null )
        {
            completingFields.add( Enter.theValue( address.getZip( ) )
                                       .into( ZIP_FIELD ) );
        }

        if( address.getCountry( ) != null )
        {
            completingFields.add( SelectFromOptions.byVisibleText( address.getCountry( ) )
                                                   .from( COUNTRY_FIELD ) );
        }

        if( address.getMobilePhone( ) != null )
        {
            completingFields.add( Enter.theValue( address.getMobilePhone( ) )
                                       .into( MOBILE_PHONE_FIELD ) );
        }

        if( address.getAddressAlias( ) != null )
        {
            completingFields.add( Enter.theValue( address.getAddressAlias( ) )
                                       .into( ADDRESS_ALIAS_FIELD ) );
        }

        Performable[] actions = completingFields.toArray( new Performable[completingFields.size( )] );
        return actions;
    }
}
