package net.jakim.testing.wab_ui;

import net.jakim.testing.utils.JRLocatorsProvider;
import org.openqa.selenium.By;

public enum Menu
    implements Locatable
{
    SIGN_IN_BUTTON( "main_menu.sign_in_button" );

    private By locator;

    Menu( final String locatorKey )
    {
        this.locator = JRLocatorsProvider.getByLocatorFor( locatorKey );
    }

    @Override
    public By getLocator( )
    {
        return this.locator;
    }
}
