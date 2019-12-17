package com.ttninc.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/emp",
        plugin = {"pretty", "html:target/cucumber"},
        extraGlue = {"com.ttninc.stepdefinitions"},
        dryRun= false)
public class CucumberIntegrationTest {
}
