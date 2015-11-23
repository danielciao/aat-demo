package com.example.cucumber

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    features = "target/classes/com/example/cucumber/features/GoogleSearch.feature",
    plugin = "json:target/test-artifacts/cucumber/googleSearch.json")
class GoogleSearchRunner {
}
