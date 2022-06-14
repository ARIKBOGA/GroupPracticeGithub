package com.meetsky.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "src/test/java/com/meetsky/step_definitions",
        //plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"},
        tags = "@Regression"
)

public class CukesRunner {
}
