package steps_libraries;


import net.jakim.page_object.MonitoringPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

public class TPMSDashboardUser {
    private MonitoringPage monitoringPage;


    @Step("starts creating new dashboards with description: {0}")
    public void startsCreatingDashboard(Map<String, String> dashboardDescription) {
        monitoringPage.clickNewDashboardButton();
        monitoringPage.enterDashboardName(dashboardDescription.get("name"));
        monitoringPage.enterDashboardDescription(dashboardDescription.get("description"));
    }

    @Step("adds machines {0} tho the dashboard")
    public void addsMachinesToTheDashboard(List<String> machines) {
        monitoringPage.goToChooseMacineTab();
        //TODO the code bellow needs to be wrapped in a loop over the machines list
        monitoringPage.searchFor(machines.get(0));
        monitoringPage.addMachineToDashboard(machines.get(0));

    }

    public void addsParametersToTheDashboard(String machinePlatform, List<String> paramsName) {
        monitoringPage.goToChooseParametersTab();
        monitoringPage.selectMachinePlatform(machinePlatform);
        monitoringPage.searchFor(paramsName.get(0));
        monitoringPage.addParameterToDashboard(paramsName.get(0));
    }

    public void savesTheDashboard() {
        monitoringPage.saveDashboard();
    }
}
