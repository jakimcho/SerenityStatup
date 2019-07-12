package net.jakim.page_object;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

@DefaultUrl("https://tpms-dev.eu.asml.com/monitoring/playground")
public class MonitoringPage extends PageObject {

    @FindBy(id = "createDashboardButton")
    private WebElementFacade newDashboardButton;

    @FindBy(name = "dashboard-name")
    private WebElementFacade dashboardNameField;

    @FindBy(name = "dashboard-desc")
    private WebElementFacade dashboardDescriptionField;

    @FindBy(css = "a[href='#machines']" )
    private WebElementFacade machinesSearchTab;

    @FindBy(css = "a[href='#parameters']" )
    private WebElementFacade parametersSearchTab;

    @FindBy(css = "input[placeholder='search']" )
    private WebElementFacade searchField;

    @FindBy(css = ".parameterButtonHolder" )
    private WebElementFacade machinesPlatformsButtons;

    @FindBy(css = ".tabs__content.leftSideMenu .list__tile" )
    private List<WebElementFacade> searchResultsElements;

    @FindBy(xpath = "//button[contains(.,' Save & Close ')]")
    private WebElementFacade saveDashboardButton;

    public void clickNewDashboardButton() {
        this.newDashboardButton.withTimeoutOf(Duration.ofMinutes(1)).waitUntilClickable().click();
    }

    public void enterDashboardName(String name) {
        this.dashboardNameField.waitUntilEnabled().type(name);
    }

    public void enterDashboardDescription(String description) {
        this.dashboardDescriptionField.waitUntilEnabled().type(description);
    }

    public void goToChooseMacineTab() {
        this.machinesSearchTab.waitUntilClickable().click();
    }

    public void searchFor(String key) {
        this.searchField.type(key);
    }

    public void addMachineToDashboard(String s) {
        WebElementFacade machine = searchResultsElements.get(0);
        machine.findBy(By.cssSelector(".addMachineGroup.btn")).waitUntilClickable().click();
    }

    public void goToChooseParametersTab() {
        this.parametersSearchTab.waitUntilClickable().click();
    }

    public void selectMachinePlatform(String machinePlatform) {
        String locator = String.format("//button[contains(.,'%s')]", machinePlatform);
        this.machinesPlatformsButtons.findBy(By.xpath(locator));
    }

    public void addParameterToDashboard(String paramName) {
        //TODO this is hardcoded for the moment. Need improvement
        searchResultsElements.get(1).findBy(By.cssSelector(".showParameterSetChildrenButton")).click();
        searchResultsElements.get(1).findBy(By.cssSelector(".addParameterGroupToDashboard.btn")).click();
    }

    public void saveDashboard(){
        this.saveDashboardButton.click();
    }
}
