package StepDefinitions;

import PreRunnerClasses.PreRunPropertiesUtils;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common_Step_Definition {
    private static final Logger logger = LogManager.getLogger(Common_Step_Definition.class);

    @Before
    public void beforeScenario() {
        logger.info("Running BeforeScenario on Common_StepDef_File");
        PreRunPropertiesUtils preRunPropertiesUtils = new PreRunPropertiesUtils();
        preRunPropertiesUtils.readConfigFiles();
        try {
            if (DriverManager.getDriver() == null) {
                logger.info("Launching Browser on Common_StepDef_File");
                DriverManager.launchBrowser();
                preRunPropertiesUtils.initWebElements();

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
