package net.jakim.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Start
        implements Task
{
    private String targetPage;

    public Start( String page )
    {
        this.targetPage = page;
    }

    public static Start withPage( String page )
    {
        return instrumented( Start.class,
                             page );
    }

    @Override
    public <T extends Actor> void performAs( T actor )
    {
        actor.attemptsTo(
                Open.browserOn( )
                    .thePageNamed( this.targetPage.toLowerCase( ) + ".page" ) );
    }
}
