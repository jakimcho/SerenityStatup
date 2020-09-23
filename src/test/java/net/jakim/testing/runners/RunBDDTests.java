package net.jakim.testing.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


@RunWith( CucumberWithSerenity.class )
@CucumberOptions(
        plugin =
                {
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml"
                },
        features = "classpath:features",
        glue = "net/jakim/testing/steps/definitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunBDDTests
{

    @BeforeClass
    public static void setReportInfo(){
        System.setProperty("system.info.name", "jakim");
    }
}
