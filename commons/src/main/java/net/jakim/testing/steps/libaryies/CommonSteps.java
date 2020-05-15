package net.jakim.testing.steps.libaryies;

import net.jakim.testing.wab_ui.BasePage;
import net.jakim.testing.wab_ui.Locatable;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;

import static net.jakim.testing.wab_ui.BasePage.ALERT_MESSAGE;

public class CommonSteps
{

    private BasePage currentPage;

    @Step
    public void opensPage( String pageName )
    {
        currentPage.openPageNamed( pageName );
    }

    @Step
    public void typesTextIntoField( final String username,
                                    final Locatable field )
    {
        currentPage
            .find( field )
            .waitUntilEnabled( )
            .type( username );
    }

    @Step
    public void clicksOn( final Locatable button )
    {
        currentPage
            .find( button )
            .waitUntilClickable( )
            .click( );
    }

    public String readsAlertMessage( )
    {
        return currentPage
            .find( ALERT_MESSAGE )
            .getText( )
            .trim( );
    }
}
