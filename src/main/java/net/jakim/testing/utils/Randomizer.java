package net.jakim.testing.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class Randomizer
{
    public static final int REPLACE_WITH_UPPER_CASE_LETTERS = 1;
    public static final int REPLACE_WITH_LOWER_CASE_LETTERS = 2;
    public static final int REPLACE_WITH_DIGITS = 3;

    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    public static String getRandomNumberAsString( int length )
    {
        log.debug( "Inside getRandomNumberAsString() method" );
        String randomNumber = randomize( DIGITS,
                                         length );

        log.debug( "Exiting getRandomNumberAsString() method" );
        return randomNumber;
    }

    public static String getRandomLowerCaseString( int length )
    {
        log.debug( "Inside getRandomLowerCaseString() method" );
        String randomLowerCaseLetters = randomize( LOWER_CASE_LETTERS,
                                                   length );

        log.debug( "Exiting getRandomLowerCaseString() method" );
        return randomLowerCaseLetters;
    }

    public static String getRandomUpperCaseString( int length )
    {
        log.debug( "Inside getRandomUpperCaseString() method" );
        String randomUpperCaseLetters = randomize( UPPER_CASE_LETTERS,
                                                   length );

        log.debug( "Exiting getRandomUpperCaseString() method" );
        return randomUpperCaseLetters;
    }

    public static String randomizeValue( String value )
    {
        log.debug( "Inside randomizeValue() method" );
        String tempValue = value;
        if ( tempValue != null )
        {
            log.debug( "Replacing placeholders with random upper case letters" );
            tempValue = replaceAllOccurrences( tempValue,
                                               REPLACE_WITH_UPPER_CASE_LETTERS );
            log.debug( "After replacing placeholders with random upper case letters: {}",
                          tempValue );

            log.debug( "Replacing placeholders with random lower case letters" );
            tempValue = replaceAllOccurrences( tempValue,
                                               REPLACE_WITH_LOWER_CASE_LETTERS );
            log.debug( "After replacing placeholders with random lower case letters: {} ",
                          tempValue );

            log.debug( "Replacing placeholders with random digits" );
            tempValue = replaceAllOccurrences( tempValue,
                                               REPLACE_WITH_DIGITS );
            log.debug( "After replacing placeholders with random digits: {}",
                          tempValue );
        }

        log.debug( "Exiting randomizeValue() method" );
        return tempValue;
    }

    ////////////////////////////////////////////// Helpers //////////////////////////////////////////////////////////
    private static String randomize( String arr,
                                     int length )
    {
        log.debug( "Inside randomize() method" );
        StringBuilder strBuilder = new StringBuilder();
        SecureRandom rand = new SecureRandom();

        log.debug( "Generating random unit with size {}",
                      length );
        for ( int i = 0; i < length; i++ )
        {
            int digitsIndex = rand.nextInt( arr.length() );
            strBuilder.append( arr.charAt( digitsIndex ) );
        }

        log.debug( "Generated random unit " + rand.toString() );
        log.debug( "Exiting getRandomNumberAsString() method" );

        return strBuilder.toString();
    }

    private static String replaceAllOccurrences( String stringValue,
                                                 int replaceSeed )
    {
        log.debug( "Inside replaceWithDigits() method" );
        String value = stringValue;
        Pattern pattern;
        String arr;

        log.debug( "Building pattern for matching" );
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

        log.debug( "Pattern for matching is build: {}",
                      pattern.toString() );
        log.debug( "Matching the provided value with built pattern: {}",
                      value );
        Matcher matcher = pattern.matcher( value );
        if ( matcher.find() )
        {
            log.debug( "Found matchings: " + matcher.groupCount() );
            for ( int groupIndex = 0; groupIndex <= matcher.groupCount(); groupIndex++ )
            {
                String capture = matcher.group( groupIndex );
                int length = Integer.valueOf( capture.replaceAll( "\\D+",
                                                                  "" ) ); // removes all non digit symbols and prepare the size of the random string
                String replacement = randomize( arr,
                                                length );
                log.debug( "Replacing matched item with: {}",
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
            log.debug( "No matchings found :(" );
        }

        log.debug( "Exiting replaceAllOccurrences() method" );
        return value;
    }
}