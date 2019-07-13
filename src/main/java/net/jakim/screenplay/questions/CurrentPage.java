package net.jakim.screenplay.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CurrentPage
        implements Question<String>
{

    @Override
    public String answeredBy( Actor actor )
    {
        return Serenity.getWebdriverManager( )
                       .getCurrentDriver( )
                       .getCurrentUrl( );
    }

    public static Question<String> url() {
        return new CurrentPage();
    }


}

