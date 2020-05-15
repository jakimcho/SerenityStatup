package net.jakim.testing.wab_ui;

import net.jakim.testing.utils.JRLocatorsProvider;
import org.openqa.selenium.By;

public enum Login
    implements Locatable
{
    USERNAME_FIELD( "login.username_field" ),
    CONTINUE_BUTTON( "login.continue_button" ),
    PASSWORD_FIELD( "login.password_field" ),
    SUBMIT_BUTTON( "login.submit_button" );

    private By locator;

    Login( final String locatorKey )
    {
        this.locator = JRLocatorsProvider.getByLocatorFor( locatorKey );
    }

    @Override
    public By getLocator( )
    {
        return this.locator;
    }
}
