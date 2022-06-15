package com.meetsky.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/meetsky/step_definitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber.json"}
)

public class CukesRunner {
}