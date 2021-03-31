package learning.cucumbercourse.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/learning/cucumbercourse/features/MenuManagement.feature"},
        glue = {"learning.cucumbercourse.stepdefinitions"},
     //   tags = "@SmokeTest or (@NightlyBuildTest and @RegularTest)",  // "not @NightlyBuildTest"
        plugin = {"pretty"}

        //run maven test with tags: mvn test -Dcucumber.filter.tags="@SmokeTest or @NightlyBuildTest"
)
public class MenuManagementTest {
}
