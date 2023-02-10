package net.jakim.test_runners;

import lombok.extern.slf4j.Slf4j;
import net.jakim.abilities.QueryTheDB;
import net.jakim.actions.SQLQuery;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;
import java.util.Map;

@Slf4j
@ExtendWith(SerenityJUnit5Extension.class)
public class SQLTest {


    private Actor indiana;

    @BeforeEach
    public void prepareActor() {
        indiana = Actor.named("Indiana Jones")
                .whoCan(new QueryTheDB());
    }

    @Test
    void validRegistration() {
        String sql = "SELECT * FROM users";
        indiana.wasAbleTo(SQLQuery.calling(sql));

        List<Map<String, String>> result = indiana.recall(sql);

        log.info("Result:\n{}", result.toString().replace("{", "\n{"));
    }
}
