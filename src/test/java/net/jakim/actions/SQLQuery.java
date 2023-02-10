package net.jakim.actions;

import net.jakim.abilities.QueryTheDB;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SQLQuery implements Performable {

    private String query;

    private List<Map<String, String>> res;

    public SQLQuery(String query) {
        this.query = query;
    }

    public static SQLQuery calling(String query) {
        return instrumented(SQLQuery.class, query);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        res = QueryTheDB.as(actor).executeQuery(query);
        actor.remember(query, res);
    }
}
