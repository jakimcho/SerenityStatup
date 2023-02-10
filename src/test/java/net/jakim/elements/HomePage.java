package net.jakim.elements;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static java.time.Duration.ofSeconds;

public class HomePage {
    public final static Target JUMBOTRON_HEADING = Target.the("Jumbotron Heading")
            .located(By.cssSelector(".jumbotron h1"))
            .waitingForNoMoreThan(ofSeconds(2));
}
