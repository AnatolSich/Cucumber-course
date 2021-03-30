package learning.cucumbercourse.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/learning/cucumbercourse/features/MenuManagement.feature"},
        glue = {"learning.cucumbercourse.stepdefinitions"},
        plugin = {"pretty"}
)
public class MenuManagementTest {
}
