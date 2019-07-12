package net.jakim.page_object;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

@DefaultUrl("https://tpms-dev.eu.asml.com/")
public class HomePage extends PageObject {
    private final static Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
    @FindBy(name = "settings-user-id")
    private WebElementFacade usernameField;

    @FindBy(name = "settings-user-password")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[contains(.,'login')]")
    private WebElementFacade loginButton;

    @FindBy(id = "toolbarUserInformation")
    private WebElementFacade avatarElement;

    public void enterUsername(String username) {
        LOGGER.info("Enter {} in login form username field", username);
        this.usernameField.waitUntilEnabled().type(username);
    }

    public void enterUserPassword(String password) {
        LOGGER.info("Enter {} in login form password field", password);
        this.passwordField.waitUntilEnabled().type(password);
    }

    public void clickLoginButton() {
        this.loginButton.waitUntilClickable().click();
    }

    public boolean isAvatartElementDisplayed(){
        boolean result = false;
        try {
            result = this.avatarElement.waitUntilVisible().isDisplayed();
        } catch (Exception e){
            System.out.println("Somethinf happend: "+ e.getMessage());
        }

        return result;
    }
}
