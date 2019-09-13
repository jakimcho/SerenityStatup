package net.jakim.page_object;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl( "http://automationpractice.com/index.php?controller=authentication&back=my-account" )
public class RegistrationPage
        extends PageObject
{
    @FindBy( id = "SubmitCreate" )
    public WebElementFacade createAnAccountButton;

    @FindBy( name = "email_create" )
    public WebElementFacade emailCreateField;

    @FindBy( id = "uniform-id_gender1" )
    public WebElementFacade titleMr;

    @FindBy( id = "uniform-id_gender2" )
    public WebElementFacade titleMrs;

    @FindBy( id = "customer_firstname" )
    public WebElementFacade firstNameField;

    @FindBy( id = "customer_lastname" )
    public WebElementFacade lastNameField;

    @FindBy( id = "email" )
    public WebElementFacade emailField;

    @FindBy( id = "passwd" )
    public WebElementFacade passwordField;

    @FindBy( id = "firstname" )
    public WebElementFacade firstname;

    @FindBy( id = "lastname" )
    public WebElementFacade lastname;

    @FindBy( id = "company" )
    public WebElementFacade companyField;

    @FindBy( id = "address1" )
    public WebElementFacade addressField;

    @FindBy( id = "city" )
    public WebElementFacade cityField;

    @FindBy( id = "uniform-id_state" )
    public WebElementFacade stateFieldSelector;

    @FindBy( id = "postcode" )
    public WebElementFacade postcodeField;

    @FindBy( id = "uniform-id_country" )
    public WebElementFacade countryFieldSelector;

    @FindBy( id = "phone_mobile" )
    public WebElementFacade phoneField;

    @FindBy( id = "alias" )
    public WebElementFacade aliasField;

    @FindBy( id = "submitAccount" )
    public WebElementFacade submitAccountButton;

    public void selectTitle( String title )
    {
        if( title.equalsIgnoreCase( "Mr." ) )
        {
            titleMr.click( );
        } else
        {
            titleMrs.click( );
        }
    }

    public void typeInDropDown( final WebElementFacade dropDown,
                                String item )
    {
        withAction( ).click( dropDown )
                     .pause( 200 )
                     .sendKeys( item )
                     .pause( 250 )
                     .sendKeys( Keys.ENTER )
                     .perform( );
    }
}
