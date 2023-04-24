package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

            @RunWith(Cucumber.class)
            @CucumberOptions(
            features = "src/test/java/features",
            glue = {"StepDefinitions"},
            tags = "@SimpleAlert",
            plugin = {"json: test-reports/json-report.json"},
            monochrome = true
    )

    public class ActivityStepRunner {

            }

