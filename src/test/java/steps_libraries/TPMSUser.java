package steps_libraries;

import net.jakim.page_object.HomePage;
import net.jakim.page_object.MonitoringPage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class TPMSUser {

    private final static Logger LOGGER = LoggerFactory.getLogger(TPMSUser.class);
    private HomePage homePage;
    private MonitoringPage monitoringPage;

    @Step("pens the application")
    public void opensTheApplication() {
        homePage.open();
    }

    @Step("fills login credentials: {0}")
    public void fillsLoginForm(Map<String, String> credentials) {
        LOGGER.info("Inside fillsLoginForm method");
        homePage.enterUsername(credentials.get("username"));
        homePage.enterUserPassword(credentials.get("password"));
        LOGGER.info("Exiting fillsLoginForm method");
    }

    public void submitsLoginForm() {
        homePage.clickLoginButton();
    }

    public void hasSuccessfullyLoggedIn() {
        Assertions.assertThat(homePage.isAvatartElementDisplayed()).as("The avatar glyph should display on successful login ").isTrue();
    }

    @Step("opens page {0}")
    public void opensPage(String monitoring) {
        monitoringPage.open();
    }
}
