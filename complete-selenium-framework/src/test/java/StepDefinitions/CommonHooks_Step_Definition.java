package StepDefinitions;

import Utils.CommonSetupUtils;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonHooks_Step_Definition {

    private static final Logger logger = LogManager.getLogger(CommonHooks_Step_Definition.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        CommonSetupUtils.setScenarioName(scenario.getName());
        logger.info("Running BeforeScenario for scenario: " + scenario.getName());

        CommonSetupUtils.getInstance().readConfigFiles();

        try {
            if (DriverManager.getDriver() == null) {
                logger.info("Launching browser from Common_Step_Definition...");
                DriverManager.launchBrowser();
                CommonSetupUtils.getInstance().initWebElements();
            }
        } catch (Exception e) {
            logger.error("Error during browser setup", e);
            throw new RuntimeException(e);
        }
    }
}
