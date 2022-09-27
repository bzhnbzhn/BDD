package com.cucumber.junit.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        glue = "com.cucumber.junit",
        features = "src/test/resources/com/cucumber/junit/features")
public class СucumberTestRunner {
}
