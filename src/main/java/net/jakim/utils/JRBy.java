package net.jakim.utils;

import com.google.common.base.Preconditions;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

/**
 * @author yakimfb
 * @since 23.01.20
 **/
public abstract class JRBy
        extends By
{

    private final static Properties props = System.getProperties();

    public static By configProps( String configKey )

    {
        return new JRBy.ConfigKey( configKey );
    }

    private static class ConfigKey
            extends By
    {

        private final String locatorKey;

        public ConfigKey( final String locator )
        {
            this.locatorKey = locator;
        }

        @Override
        public List<WebElement> findElements( SearchContext searchContext )
        {
            String property = props.getProperty( this.locatorKey );
            Preconditions.checkNotNull( property );
            return searchContext.findElements( extractLocatorFrom( property ) );
        }

        @Override
        public WebElement findElement( SearchContext searchContext )
        {
            String property = props.getProperty( this.locatorKey );
            Preconditions.checkNotNull( property );
            return searchContext.findElement( extractLocatorFrom( property ) );
        }

    }


    private static By extractLocatorFrom( String rawLocator )
    {
        String propertySegments[] = rawLocator.split( ":" );
        String locatorStrategy = "css"; // default locator if no is provided in the 'rawLocator' prop
        By byLocator = null;
        if ( propertySegments.length > 1 )
        {
            locatorStrategy = propertySegments[0].toLowerCase()
                                                 .trim();
        }

        String locator = propertySegments[propertySegments.length - 1].trim();

        switch ( locatorStrategy )
        {
            case "css":
                byLocator = By.cssSelector( locator );
                break;
            case "xpath":
                byLocator = By.xpath( locator );
                break;
            case "id":
                byLocator = By.id( locator );
                break;
            case "name":
                byLocator = By.name( locator );
                break;
            default:
                throw new RuntimeException( "No such locator strategy: " + locatorStrategy );
        }

        return byLocator;
    }

}
