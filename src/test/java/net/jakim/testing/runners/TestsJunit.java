package net.jakim.testing.runners;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.abilities.BrowsingTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.log.Log;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;

@Slf4j
@ExtendWith(SerenityJUnit5Extension.class)
public class TestsJunit {

    @Managed(driver = "chrome")
    WebDriverFacade driver;

    @Test
    void manageLocalStorage() {
        driver.navigate().to("https://dir.bg/");
        LocalStorage lc = ((WebStorage) driver.getProxiedDriver()).getLocalStorage();
        for (String key : lc.keySet()) {
            log.info("{} kye has item {}", key, lc.getItem(key));
        }

        lc.setItem("JAKIM", "Кой сега е номер едно?");

        driver.quit();
    }

    @Test
    void readConsole() {
        DevTools devTools = ((ChromeDriver) driver.getProxiedDriver()).getDevTools();
        devTools.createSession();

        devTools.send(Log.enable());
        devTools.addListener(Log.entryAdded(),
                logEntry -> {
                    log.info("############# log: " + logEntry.getText());
                    log.info("########## level: " + logEntry.getLevel());
                });

        driver.navigate().to("https://dir.bg/");

        while (true){

        }


    }

}
