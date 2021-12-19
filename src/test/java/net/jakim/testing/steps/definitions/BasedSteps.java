package net.jakim.testing.steps.definitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.jakim.testing.screenplay.tasks.Start;
import net.serenitybdd.core.pages.PageComponent;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BasedSteps {

    @Given("{} is on {page} page")
    public void UserIsOnPageNames(String actorName, String page) {
        theActorCalled(actorName).attemptsTo(Start.withPage(page));
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

}
