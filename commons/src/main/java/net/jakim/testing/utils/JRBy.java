package net.jakim.testing.utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.core.selectors.Selectors.xpathOrCssSelector;

@Slf4j
public class JRBy
    extends By
{
    private final static String strategies[] = { "id:", "xpath:", "css:", "name:" };
    private final By locator;

    private JRBy( String jrFormattedLocator )
    {
        this.locator = extractLocatorFrom( jrFormattedLocator );
    }

    // format is: [strategy]: [locator]
    // where strategy is optional
    public static By locator( String jrFormattedLocator )
    {
        return new JRBy( jrFormattedLocator );
    }

    private static By extractLocatorFrom( String rawLocator )
    {
        log.debug( "Inside extractLocatorFrom() method" );
        log.debug( "Extracting locator strategy from '{}' raw rawLocator",
                   rawLocator );
        String locatorStrategy = Arrays
            .stream( strategies )
            .filter( strategy -> rawLocator.startsWith( strategy ) )
            .findFirst( )
            .orElse( "xpath or css:" )
            .trim( );

        log.debug( "Locator strategy is {}",
                   locatorStrategy );
        log.debug( "Extracting locator selector from {}",
                   rawLocator );
        String locator = rawLocator
            .replace( locatorStrategy,
                      "" )
            .trim( );

        log.debug( "Locator selector is {}",
                   locator );
        By byLocator = null;
        switch ( locatorStrategy )
        {
            case "css:":
                log.debug( "Building a selenium 'CSS' By locator object" );
                byLocator = By.cssSelector( locator );

                break;
            case "xpath:":
                log.debug( "Building a selenium 'XPATH' By locator object" );
                byLocator = By.xpath( locator );
                break;
            case "id:":
                log.debug( "Building a selenium 'ID' By locator object" );
                byLocator = By.id( locator );
                break;
            case "name:":
                log.debug( "Building a selenium 'Name' By locator object" );
                byLocator = By.name( locator );
                break;
            case "xpath or css:":
                log.info( "Building a selenium 'Xpath or CSS' By locator object" );
                byLocator = xpathOrCssSelector( locator );
                break;
            default:
                log.warn( "No such locator strategy" );
                throw new RuntimeException( "No such locator strategy: " + locatorStrategy );
        }

        log.debug( "Exiting extractLocatorFrom() method" );
        return byLocator;
    }

    @Override
    public List<WebElement> findElements( SearchContext searchContext )
    {
        return searchContext.findElements( this.locator );
    }

    @Override
    public WebElement findElement( SearchContext searchContext )
    {
        return searchContext.findElement( this.locator );
    }

    @Override
    public String toString( )
    {
        return "JRBy: " + this.locator.toString( );
    }

}
