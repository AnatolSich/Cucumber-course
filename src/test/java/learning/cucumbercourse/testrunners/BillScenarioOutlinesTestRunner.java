package learning.cucumbercourse.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/learning/cucumbercourse/features/ScenarioOutlineExample.feature"},
        glue = {"learning.cucumbercourse.stepdefinitions"},
        plugin = {"pretty"},
        tags = "@ScenarioOutlineExample",
        dryRun = false,
        monochrome = false
)

public class BillScenarioOutlinesTestRunner {
}
