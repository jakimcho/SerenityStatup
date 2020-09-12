package net.jakim.testing.pages;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Slf4j
public class BasePage extends PageObject
{
    public static final By PAGE_HEADING_MESSAGE = By.cssSelector(".container h2");

    public WebElementFacade findByXpathWIthPlaceholder(String departmentWithPlaceholder, Object... args )
    {
        log.debug( "Inside findByXpathWIthPlaceholder() method" );
        String xpathString = String.format( departmentWithPlaceholder, args );
        log.info( "Searching for element with xpath \"{}\"", xpathString );
        By xpathLocator = By.xpath( xpathString );
        log.debug( "Exiting findByXpathWIthPlaceholder() method" );
        return find( xpathLocator );
    }

    public String getTextFromElement( WebElement elementFacade )
    {
        log.debug( "Inside getTextFromElement() method" );
        String elementText = elementFacade.getText( ).trim( );
        log.debug( "Found text \"{}\"", elementText );
        log.debug( "Exiting getTextFromElement() method" );
        return elementText;
    }

    public String getTextFromElement( By locator )
    {
        return getTextFromElement( ( WebElement ) find( locator ) );
    }

}
