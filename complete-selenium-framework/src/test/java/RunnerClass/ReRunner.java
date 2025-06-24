package RunnerClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failed_scenarios.txt",
//        dryRun = true,
        monochrome = true,
        glue = "StepDefinitions"
)
public class ReRunner {
}
