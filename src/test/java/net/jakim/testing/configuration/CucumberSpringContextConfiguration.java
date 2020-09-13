package net.jakim.testing.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@ComponentScan(basePackages = "net.jakim.testing.services" )
@PropertySource("classpath:configuration.properties")
public class CucumberSpringContextConfiguration {
}

