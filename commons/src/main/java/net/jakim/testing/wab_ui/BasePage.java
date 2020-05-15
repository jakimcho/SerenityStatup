package net.jakim.testing.wab_ui;

import net.jakim.testing.utils.JRLocatorsProvider;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

public class BasePage
    extends PageObject
{
    public final static By ALERT_MESSAGE = JRLocatorsProvider.getByLocatorFor( "main.alert_message" );

    public WebElementFacade find( Locatable locatableElement )
    {
        return this.find( locatableElement.getLocator( ) );
    }

}
