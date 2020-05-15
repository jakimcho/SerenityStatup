package net.jakim.testing.utils;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class JRLocatorsProvider
{
    private final static String COMMON_LOCATORS_LOCATION = "common/locators";
    private static final String DEFAULT_SITE_LOCATORS_DIR = "locators";
    private static final Properties locatorProperties = new Properties( );

    private JRLocatorsProvider( )
    {
        log.debug( "Inside JRLocatorsProvider() constructor" );
        log.debug( "Create input stream from {} resources",
                   COMMON_LOCATORS_LOCATION );
        try ( InputStream resourcesStream = streamAllLocatorsResourcesFromPath( COMMON_LOCATORS_LOCATION ) )
        {
            log.debug( "Loading locators" );
            locatorProperties.load( resourcesStream );
        }
        catch ( IOException e )
        {
            log.error( "Something went wrong {}",
                       e.getMessage( ) );
            e.printStackTrace( );
        }

        log.debug( "Exiting JRLocatorsProvider() constructor" );
    }

    private static InputStream streamAllLocatorsResourcesFromPath( final String locatorsResourceDir )
    {
        log.debug( "Inside streamAllLocatorsResourcesFromPath(  ) method" );
        Enumeration<InputStream> streamedLocatorFiles = streamAllFiles( locatorsResourceDir );
        InputStream sequenceInputStream = new SequenceInputStream( streamedLocatorFiles );
        log.debug( "Exiting streamAllLocatorsResourcesFromPath(  ) method" );
        return sequenceInputStream;
    }

    private static Enumeration<InputStream> streamAllFiles( final String locatorsResourceDir )
    {
        log.debug( "Inside streamAllFiles( ) method" );
        Vector<InputStream> files = new Vector<>( );
        String newLine = "\n\r";
        try ( InputStream resourcesStream = getResourceAsStream( locatorsResourceDir ) )
        {
            log.debug( "Reading all files from {} as streams",
                       locatorsResourceDir );
            BufferedReader br = new BufferedReader( new InputStreamReader( resourcesStream ) );
            String fileName;
            while ( ( fileName = br.readLine( ) ) != null )
            {
                files.add( getResourceAsStream( locatorsResourceDir,
                                                fileName ) );
                // We need that line separator for every next files, otherwise the end line of file 1 will concat with file 2 star line
                files.add( new ByteArrayInputStream( newLine.getBytes( ) ) );
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace( );
        }

        log.debug( "Exiting streamAllFiles(  ) method" );
        return files.elements( );
    }

    private static InputStream getResourceAsStream( final String... pathTokens )
    {
        log.debug( "Inside getResourceAsStream(  ) method" );
        String resourcePath = "";
        for ( String token : pathTokens )
        {
            resourcePath += "/" + token;
        }

        log.debug( "Retrieving stream from resource: {}",
                   resourcePath );
        InputStream stream = JRLocatorsProvider.class.getResourceAsStream( resourcePath );
        log.debug( "Exiting getResourceAsStream(  ) method" );
        return stream;
    }

    public static void init( String locatorsFilePath )
    {
        log.debug( "Inside init( String ) method" );
        File file = new File( locatorsFilePath );
        try ( InputStream in = new FileInputStream( file.getAbsoluteFile( ) ) )
        {
            log.debug( "Create input stream from {} resources",
                       file.getAbsolutePath( ) );
            init( in );
        }
        catch ( IOException e )
        {
            log.error( "Something went wrong {}",
                       e.getMessage( ) );
            e.printStackTrace( );
        }

        log.debug( "Exiting init() constructor" );
    }

    public static void init( final InputStream locatorsIn )
    {
        log.debug( "Inside init( InputStream ) method" );
        try
        {
            log.debug( "Loading locators from the input stream" );
            locatorProperties.load( locatorsIn );
        }
        catch ( IOException e )
        {
            log.error( "Something went wrong {}",
                       e.getMessage( ) );
            e.printStackTrace( );
        }

        log.debug( "Exiting init( InputStream ) method" );
    }

    public static void initFromResourceDir( )
    {
        initFromResourceDir( DEFAULT_SITE_LOCATORS_DIR );
    }

    public static void initFromResourceDir( final String locatorsResourceDir )
    {
        log.debug( "Inside initFromResourceDir( InputStream ) method" );
        try ( InputStream resourcesStream = streamAllLocatorsResourcesFromPath( locatorsResourceDir ) )
        {
            log.debug( "Loading locators from all .properties files in {} resource path",
                       locatorsResourceDir );
            init( resourcesStream );
        }
        catch ( IOException e )
        {
            log.error( "Something went wrong {}",
                       e.getMessage( ) );
            e.printStackTrace( );
        }

        log.debug( "Exiting initFromResourceDir( InputStream ) method" );
    }

    public static By getByLocatorFor( String locatorKey )
    {
        log.debug( "Inside getByLocatorFor( String ) method" );
        By locator = JRBy.locator( getLocatorValue( locatorKey ) );
        log.debug( "Exiting getByLocatorFor( String ) method" );
        return locator;
    }

    public static By getByLocatorFromTemplate( String locatorKey,
                                               String... placeholdersValues )
    {
        log.debug( "Inside getByLocatorForTemplate() method" );
        String completeLocator = formatCompleteLocator( getLocatorValue( locatorKey ),
                                                        placeholdersValues );
        log.info( "Formed locator for template is: {}",
                  completeLocator );
        By locator = JRBy.locator( completeLocator );
        log.debug( "Exiting getByLocatorForTemplate() method" );
        return locator;
    }

    private static String formatCompleteLocator( final String locatorKey,
                                                 final String... originPlaceholdersValues )
    {
        log.debug( "Inside formatCompleteLocator() method" );
        int originalPlaceholdersValuesNumber = originPlaceholdersValues.length;
        int originalPlaceHoldersCount = getPlaceHoldersCount( locatorKey );
        log.debug( "Found {} placeholders and {} placeholders values",
                   originalPlaceHoldersCount,
                   originalPlaceholdersValuesNumber );

        List<String> placeHoldersValues = Lists.newArrayList( originPlaceholdersValues );

        // Finding the difference between original placeholders number and what is expected.
        // Complete placeHoldersValues list with that difference duplicating the last placeholder from the original array.
        int countDifference = originalPlaceHoldersCount - originalPlaceholdersValuesNumber;
        while ( countDifference > 0 )
        {
            log.debug( "Adding additional placeholder" );
            placeHoldersValues.add( originPlaceholdersValues[ originalPlaceholdersValuesNumber - 1 ] );
            countDifference--;
        }

        log.debug( "Exiting formatCompleteLocator() method" );
        return String.format( locatorKey,
                              placeHoldersValues.toArray( ) );
    }

    private static int getPlaceHoldersCount( final String locatorKey )
    {
        Pattern pt = Pattern.compile( "%s|%d|%f" );
        Matcher matcher = pt.matcher( locatorKey );
        int counter = 0;
        while ( matcher.find( ) )
        {
            counter++;
        }

        return counter;
    }

    public static String getLocatorValue( final String locatorKey )
    {
        log.debug( "Inside getLocatorValue() method" );
        Preconditions.checkNotNull( locatorKey );
        String locatorValue = "Not Defined in the properties";
        log.debug( "Checking if key '{}' is set in the locators properties",
                   locatorKey );
        if ( !locatorProperties.containsKey( locatorKey ) )
        {
            log.warn( "Locator key '{}' is not set",
                      locatorKey );
        }
        else
        {
            locatorValue = locatorProperties.getProperty( locatorKey );
            log.debug( "Got locator '{}' value for key '{}'",
                       locatorValue,
                       locatorKey );
            Preconditions.checkNotNull( locatorValue );
        }
        log.debug( "Exiting getLocatorValue() method" );
        return locatorValue;
    }

    // This is here only for debugging purpose
    public static String listLocators( )
    {
        StringBuilder sb = new StringBuilder( );
        for ( Map.Entry entry : locatorProperties.entrySet( ) )
        {
            sb
                .append( "\n" )
                .append( entry.getKey( ) )
                .append( " : " )
                .append( entry.getValue( ) );
        }
        return sb.toString( );
    }
}
