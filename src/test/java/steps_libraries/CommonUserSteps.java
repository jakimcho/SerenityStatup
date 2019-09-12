package steps_libraries;

import net.jakim.entities.Address;
import net.jakim.entities.User;
import net.jakim.page_object.MyAccountPage;
import net.jakim.page_object.RegistrationPage;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.*;

public class CommonUserSteps
{
    private RegistrationPage registrationPage;
    private MyAccountPage myAccountPage;

    @Step( "User opens the sign-in page {0}" )
    public void opensRegistrationPage( )
    {
        registrationPage.open( );
    }

    @Step( "Types in the initial email" )
    public void startsAccountCreation( final User user )
    {
        registrationPage.typeInto( registrationPage.emailCreateField,
                                   user.getEmail( ) );
        registrationPage.clickOn( registrationPage.createAnAccountButton );
    }

    @Step( "Types in the personal information" )
    public void fillsInPersonalInformation( final User user )
    {
        registrationPage.selectTitle( user.getTitle( ) );
        registrationPage.typeInto( registrationPage.firstNameField,
                                   user.getFirstName( ) );
        registrationPage.typeInto( registrationPage.lastNameField,
                                   user.getLastName( ) );
        registrationPage.typeInto( registrationPage.emailField,
                                   user.getEmail( ) );
        registrationPage.typeInto( registrationPage.passwordField,
                                   user.getPassword( ) );
    }

    @Step
    public void fillsInAddressInformation( final Address address )
    {
        registrationPage.typeInto( registrationPage.firstname,
                                   address.getFirstName( ) );
        registrationPage.typeInto( registrationPage.lastname,
                                   address.getLastName( ) );
        registrationPage.typeInto( registrationPage.companyField,
                                   address.getCompany( ) );
        registrationPage.typeInto( registrationPage.addressField,
                                   address.getAddress( ) );
        registrationPage.typeInto( registrationPage.cityField,
                                   address.getCity( ) );
        registrationPage.typeInDropDown( registrationPage.stateFieldSelector,
                                         address.getState( ) );
        registrationPage.typeInto( registrationPage.postcodeField,
                                   address.getPostalCode( ) );
        registrationPage.typeInDropDown( registrationPage.countryFieldSelector,
                                         address.getCountry( ) );
        registrationPage.typeInto( registrationPage.phoneField,
                                   address.getMobilePhone( ) );
        registrationPage.typeInto( registrationPage.aliasField,
                                   address.getAlias( ) );
    }

    @Step
    public void clicksOnRegister( )
    {
        registrationPage.clickOn( registrationPage.submitAccountButton );
    }

    public void hasRegisteredSuccessfully( )
    {
//        assertThat(myAccountPage.getDriver().getCurrentUrl())
        assertThat( myAccountPage.infoAccountText.getText( )
                                                 .trim( ) ).isEqualTo( "Welcome to your account. Here you can manage all of your personal information and orders." );
    }
}
