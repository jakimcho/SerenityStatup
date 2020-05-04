package net.jakim.testing.pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

@Slf4j
public class MainPage
        extends PageObject {
    public static final String WEB_VIEW = "WEBVIEW_air";
    public static final String NATIVE_APP = "NATIVE_APP";
    private static AndroidDriver androidDriver;

    public final static By LOGIN_MENU = By.cssSelector("#header-right a[title='Login']");
    private String mainWindow;

    public void waitForWebContextAvailability() {
        log.info("Inside waitForWebContextAvailability() method");
        int attempt = 0;
        while (webViewContextIsMissing()) {
            log.info("Wait for Web Context attempt {}",
                    attempt);
            if (attempt > 60) {
                log.error("WEBVIEW was not available");
                throw new RuntimeException("WEBVIEW was not available");
            }

            waitOnPage(ofSeconds(1));
            attempt++;
        }

        log.info("Exiting waitForWebContextAvailability() method");
    }

    private boolean webViewContextIsMissing() {
        log.info("Inside webViewContextIsMissing() method");
        Set<String> contexts = getAndroidDriver().getContextHandles();
        for (String context : contexts) {
            if (context.contains(WEB_VIEW)) {
                log.info("WebView context found");
                return false;
            }
        }

        log.info("WebView context NOT found");
        log.info("Exiting webViewContextIsMissing() method");
        return true;
    }

    private AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public void switchToWebViewContext() {
        log.info("Inside switchToWebViewContext() method");
        switchToContext(WEB_VIEW);
        log.info("Exiting switchToWebViewContext() method");
    }

    public void switchToNativeContext() {
        log.info("Inside switchToNativeContext() method");
        switchToContext(NATIVE_APP);
        log.info("Exiting switchToNativeContext() method");
    }

    private void switchToContext(String contextPartName) {
        log.info("Inside switchToContext() method");
        Set<String> contexts = getAndroidDriver().getContextHandles();
        contexts.forEach(context -> {
            log.info("Expecting context: {}",
                    context);
            if (context.contains(contextPartName)) {
                log.info("Switching to {} app context",
                        contextPartName);
                androidDriver.context(context);
            }
        });

        log.info("Exiting switchToContext() method");
    }

    public BufferedImage captureScreen() {
        log.info("Inside captureScreen() method");
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            log.info("Exiting captureScreen() method");
            return ImageIO.read(screenshot);
        } catch (IOException e) {
            log.error("Problem converting screenshot");
            e.printStackTrace();
            throw new RuntimeException("Problem occurred while taking a screenshot");
        }

    }

    public void waitOnPage(Duration duration) {
        log.info("Inside waitOnPage() method");
        log.info("Wait for {} milliseconds",
                duration.toMillis());
        waitABit(duration.toMillis());
        log.info("Exiting waitOnPage() method");
    }

    public void tapOn(Point pointToTap) {
        log.info("Inside tapOn() method");
        log.info("Tap on: {}",
                pointToTap);
        new TouchAction(androidDriver)
                .tap(PointOption.point(pointToTap))
                .waitAction(waitOptions(ofSeconds(1)))
                .perform();
        log.info("Exiting tapOn() method");
    }

    public void tapOn(final By byLocator) {
        log.info("Inside tapOn() method");
        log.info("Tap on {}",
                byLocator);
        find(byLocator)
                .click();
        log.info("Inside tapOn() method");
    }

    public void setAndroidDriver(final AndroidDriver ad) {
        log.info("Inside setAndroidDriver() method");
        androidDriver = ad;
        Serenity
                .setSessionVariable("myDriver")
                .to(androidDriver);
        log.info("Got main Window handle: {}", mainWindow);
        log.info("Exiting setAndroidDriver() method");
    }
}
