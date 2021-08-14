package net.jakim.testing.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith( CucumberWithSerenity.class )
@CucumberOptions(
        plugin =
                {
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml"
                },
        features = "./features",
        glue = "net/jakim/testing/steps/definitions",
        snippets = CAMELCASE)
public class RunBDDTests
{}
