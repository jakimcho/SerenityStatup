package net.jakim.testing.steps.libraries;

import io.appium.java_client.android.AndroidDriver;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import net.jakim.testing.pages.MainPage;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.awt.image.BufferedImage;
import java.time.Duration;

import static net.jakim.testing.utils.Tess.EN_OCR;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@Slf4j
public class LoginActions
{
    public static final String ENVIRONMENTS_PROMPT_TITLE = "select server";
    private MainPage mainPage;

    public void waitsForEnvironmentsPromptScreen( )
    {
        log.info( "Inside waitsForEnvironmentsPromptScreen() method" );
        boolean screenIsNotShown = true;
        int maxAttempts = 10;
        int attempt = 0;

        while ( screenIsNotShown )
        {
            attempt++;
            log.info( "Attempt {}",
                      attempt );
            if ( attempt >= maxAttempts )
            {
                log.error( "Screen was not shown" );
                throw new RuntimeException( "Screen was not shown" );
            }

            mainPage.waitOnPage( Duration.ofSeconds( 1 ) );
            BufferedImage screenCapture = mainPage.captureScreen( );
            String screenCaptureText = EN_OCR.extractTextFrom( screenCapture );
            log.info( "Got {} text from the screenshot",
                      screenCaptureText );
            screenIsNotShown = !screenCaptureText
                .toLowerCase( )
                .contains( ENVIRONMENTS_PROMPT_TITLE );
        }
        log.info( "Prompt Window was found" );
        log.info( "Exiting waitsForEnvironmentsPromptScreen() method" );
    }

    public void selectsTheTargetEnvironment( )
    {
        log.info( "Inside selectsTheTargetEnvironment() method" );
        BufferedImage screenCapture = mainPage.captureScreen( );
        /*
            TODO: Find a way to select the correct environment
             Point point = EN_OCR.getTextStartCoordsFromImage( "(oa",
                                                           screenCapture );
         */

        Point point = EN_OCR.getTextCenterCoordsFromImage( "Pennsylvania",
                                                           screenCapture );
        log.info( "Inside got Pennsylvania clicking point at {}",
                  point );
        mainPage.tapOn( point );
        log.info( "Exiting selectsTheTargetEnvironment() method" );
    }

    public void tapsOn( By byLocator )
    {
        log.info( "Inside tapsOn() method" );
        mainPage.waitForWebContextAvailability( );
        mainPage.switchToWebViewContext( );
        mainPage.tapOn( byLocator );
        mainPage.switchToNativeContext( );
        log.info( "Exiting tapsOn() method" );
    }

    public void entersTextInField( final String text,
                                   final By fieldLocator )
    {
        log.info( "Inside entersTextInField() method" );
        mainPage.waitForWebContextAvailability( );
        mainPage.switchToWebViewContext( );
        mainPage
            .find( fieldLocator )
            .waitUntilEnabled( )
            .and( )
            .type( text );

        log.info( "Exiting entersTextInField() method" );
    }

    public void starts( )
    {
        log.info( "Inside starts() method" );
        AndroidDriver ad = ( ( AndroidDriver ) ( ( WebDriverFacade ) getDriver( ) ).getProxiedDriver( ) );
        mainPage.setAndroidDriver( ad );
        log.info( "Exiting starts() method" );
    }
}
