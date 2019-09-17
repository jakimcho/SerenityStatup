package test_runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.model.DataTable;
import org.junit.runner.RunWith;

@RunWith( CucumberWithSerenity.class )
@CucumberOptions(
        plugin =
                {
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml"
                },
        features = "features/",
        glue = "steps_definition",
        snippets = SnippetType.CAMELCASE,
        tags = { "@regression" } )
public class RunBDDTests
{

}
