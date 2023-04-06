package net.jakim.testing.services;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GreetingService {

    private final int rand;
    private final EnvironmentSpecificConfiguration environmentSpecificConfiguration;

    public void sayHello(){
        System.out.println("HELLO!!!!");
    }

    public GreetingService(){
        Random r = new Random();
        this.rand = r.nextInt(1000);
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();
        this.environmentSpecificConfiguration = EnvironmentSpecificConfiguration.from(environmentVariables);
    }

    public void printMyNum(){
        System.out.println("Hello Random num: " + rand);
    }

    public void printSerenityProperties(){
        System.out.println(this.environmentSpecificConfiguration.getProperty("pages.home"));

    }
}
