package net.jakim.testing.runners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import net.jakim.testing.utils.JRLocatorsProvider;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith ( CucumberSerenityRunner.class )
@CucumberOptions ( glue = { "net.jakim.testing.steps.definitions" }, features = "features", tags = { "@debug" } )
public class AmazonAutomationRunner
{

    @BeforeClass
    public static void init( )
    {
        JRLocatorsProvider.initFromResourceDir( );
    }

}
