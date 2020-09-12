package net.jakim.testing.steps.libraries;

import lombok.extern.slf4j.Slf4j;
import net.jakim.testing.pages.BasePage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

@Slf4j
public class BaseWebActions {
    protected BasePage currentPage;

    @Step("Opens \"{0}\" page")
    public void opensPage(String pageName) {
        log.info("Opening '{}' page", pageName);
        currentPage.openPageNamed(normalizePageName(pageName));
    }

    @NotNull
    private String normalizePageName(String pageName) {
        log.debug("Normalizing page name {}", pageName);
        String finalPageName = pageName.trim().toLowerCase().replace(" ", "_");
        log.debug("Normalized page name is {}", finalPageName);
        return finalPageName;
    }

    public void typesTextInField(String text, By fieldLocator) {
        log.debug("Inside typesTextInField() method");
        // We don't want to execute this operation if text is null and to spam the report
        if (text != null) {
            report_typesTextInField(text, fieldLocator);
        }

        log.debug("Exiting typesTextInField() method");
    }

    @Step("Enters \"{0}\" in field \"{1}\"")
    protected final void report_typesTextInField(String text, By fieldLocator) {
        log.debug("Inside typesTextInFieldAndReport() method");
        log.info("Typing '{}' into '{}'", text, fieldLocator);
        currentPage.find(fieldLocator).and().type(text);
        log.debug("Exiting typesTextInFieldAndReport() method");
    }

    @Step("Clicks on \"{0}\"")
    public void clicksOn(By elementLocator) {
        log.debug("Inside clicksOn() method");
        currentPage.find(elementLocator).waitUntilClickable().and().click();
        log.debug("Exiting clicksOn() method");
    }

    @Step("Clicks on \"{0}\"")
    public void clicksOn(WebElementFacade webElement) {
        log.debug("Inside clicksOn() method");
        webElement.waitUntilClickable().and().click();
        log.debug("Exiting clicksOn() method");
    }

    @Step("Clicks on item number \"{0}\" from the list")
    public void clicksOnItemNumberFromList(Integer itemNumber, By searchResultItems) {
        log.debug("Inside clicksOnItemNumberFromList() method");
        currentPage.findAll(searchResultItems).get(itemNumber - 1).waitUntilClickable().and().click();
        log.debug("Exiting clicksOnItemNumberFromList() method");
    }

    @Step("Selects item \"{0}\" from drop down \"{1}\"")
    public void selectsItemFromDropDown(String itemName, By dropDownLocator) {
        log.debug("Inside selectsItemFromDropDown() method");
        currentPage.find(dropDownLocator).and().selectByVisibleText(itemName);
        log.debug("Exiting selectsItemFromDropDown() method");
    }

    public String seesTextFrom(By locator) {
        return currentPage.getTextFromElement(locator);
    }
}
