package test_runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
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
        features = "features/",
        glue = "steps_definition",
        snippets = SnippetType.CAMELCASE,
        tags = { "@jr:demo" } )
public class RunBDDTests
{

    @BeforeClass
    public static void initMe(){
        System.setProperty( "test.custom.locator.1", "css: #center_column h1" );
        System.setProperty( "test.custom.locator.2", "xpath: //[@id='center_column']/h1");
        System.setProperty( "test.custom.locator.3", "name: email_create" );
    }

}
