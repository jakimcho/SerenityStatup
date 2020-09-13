package net.jakim.testing.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Scope("prototype")
public class GreetingService {

    private final int rand;

    public void sayHello(){
        System.out.println("HELLO!!!!");
    }

    public GreetingService(){
        Random r = new Random();
        this.rand = r.nextInt(1000);
    }

    public void printMyNum(){
        System.out.println("Hello Random num: " + rand);
    }
}
