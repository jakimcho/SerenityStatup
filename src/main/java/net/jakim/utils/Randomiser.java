package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Randomiser
{
    public static final int REPLACE_WITH_UPPER_CASE_LETTERS = 1;
    public static final int REPLACE_WITH_LOWER_CASE_LETTERS = 2;
    public static final int REPLACE_WITH_DIGITS = 3;

    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static Logger logger = LoggerFactory.getLogger( Randomiser.class.getName( ) );

    public static String getRandomNumberAsString( int length )
    {
        logger.debug( "Inside getRandomNumberAsString() method" );
        String randomNumber = randomize( DIGITS,
                                         length );

        logger.debug( "Exiting getRandomNumberAsString() method" );
        return randomNumber;
    }

    public static String getRandomLowerCaseString( int length )
    {
        logger.debug( "Inside getRandomLowerCaseString() method" );
        String randomLowerCaseLetters = randomize( LOWER_CASE_LETTERS,
                                                   length );

        logger.debug( "Exiting getRandomLowerCaseString() method" );
        return randomLowerCaseLetters;
    }

    public static String getRandomUpperCaseString( int length )
    {
        logger.debug( "Inside getRandomUpperCaseString() method" );
        String randomUpperCaseLetters = randomize( UPPER_CASE_LETTERS,
                                                   length );

        logger.debug( "Exiting getRandomUpperCaseString() method" );
        return randomUpperCaseLetters;
    }

    public static String randomizeValue( String value )
    {
        logger.debug( "Inside randomizeValue() method" );
        String tempValue = value;
        if ( tempValue != null )
        {
            logger.debug( "Replacing placeholders with random upper case letters" );
            tempValue = replaceAllOccurrences( tempValue,
                                               REPLACE_WITH_UPPER_CASE_LETTERS );
            logger.debug( "After replacing placeholders with random upper case letters: {}",
                          tempValue );

            logger.debug( "Replacing placeholders with random lower case letters" );
            tempValue = replaceAllOccurrences( tempValue,
                                               REPLACE_WITH_LOWER_CASE_LETTERS );
            logger.debug( "After replacing placeholders with random lower case letters: {} ",
                          tempValue );

            logger.debug( "Replacing placeholders with random digits" );
            tempValue = replaceAllOccurrences( tempValue,
                                               REPLACE_WITH_DIGITS );
            logger.debug( "After replacing placeholders with random digits: {}",
                          tempValue );
        }

        logger.debug( "Exiting randomizeValue() method" );
        return tempValue;
    }

    ////////////////////////////////////////////// Helpers //////////////////////////////////////////////////////////
    private static String randomize( String arr,
                                     int length )
    {
        logger.debug( "Inside randomize() method" );
        StringBuilder strBuilder = new StringBuilder();
        SecureRandom rand = new SecureRandom();

        logger.debug( "Generating random unit with size {}",
                      length );
        for ( int i = 0; i < length; i++ )
        {
            int digitsIndex = rand.nextInt( arr.length() );
            strBuilder.append( arr.charAt( digitsIndex ) );
        }

        logger.debug( "Generated random unit " + rand.toString() );
        logger.debug( "Exiting getRandomNumberAsString() method" );

        return strBuilder.toString();
    }

    private static String replaceAllOccurrences( String stringValue,
                                                 int replaceSeed )
    {
        logger.debug( "Inside replaceWithDigits() method" );
        String value = stringValue;
        Pattern pattern;
        String arr;

        logger.debug( "Building pattern for matching" );
        switch ( replaceSeed )
        {
            case REPLACE_WITH_UPPER_CASE_LETTERS:
                pattern = Pattern.compile( "\\[\\d*A\\]" );
                arr = UPPER_CASE_LETTERS;
                break;
            case REPLACE_WITH_LOWER_CASE_LETTERS:
                pattern = Pattern.compile( "\\[\\d*a\\]" );
                arr = LOWER_CASE_LETTERS;
                break;
            case REPLACE_WITH_DIGITS:
                pattern = Pattern.compile( "\\[\\d*\\]" );
                arr = DIGITS;
                break;
            default:
                return value;
        }

        logger.debug( "Pattern for matching is build: {}",
                      pattern.toString() );
        logger.debug( "Matching the provided value with built pattern: {}",
                      value );
        Matcher matcher = pattern.matcher( value );
        if ( matcher.find() )
        {
            logger.debug( "Found matchings: " + matcher.groupCount() );
            for ( int groupIndex = 0; groupIndex <= matcher.groupCount(); groupIndex++ )
            {
                String capture = matcher.group( groupIndex );
                int length = Integer.valueOf( capture.replaceAll( "\\D+",
                                                                  "" ) ); // removes all non digit symbols and prepare the size of the random string
                String replacement = randomize( arr,
                                                length );
                logger.debug( "Replacing matched item with: {}",
                              replacement );
                capture = capture.replaceAll( "\\[",
                                              "\\\\[" );
                capture = capture.replaceAll( "\\]",
                                              "\\\\]" );

                value = value.replaceFirst( capture,
                                            replacement );
            }
        } else
        {
            logger.debug( "No matchings found :(" );
        }

        logger.debug( "Exiting replaceAllOccurrences() method" );
        return value;
    }
}