package StepDefinitions;

import PreRunnerClasses.PreRunPropertiesUtils;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Common_Step_Definition {
    public static WebDriver driver;
    private static final Logger logger = LogManager.getLogger(Common_Step_Definition.class);

    @Before
    public void beforeScenario(){
        logger.info("Running BeforeScenario on Common_StepDef_File");
        PreRunPropertiesUtils preRunPropertiesUtils = new PreRunPropertiesUtils();
        preRunPropertiesUtils.readConfigFiles();
        try {
            logger.info("Launching Browser on Common_StepDef_File");
            launchBrowser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void launchBrowser() {
        logger.info("The Browser Selected: " + PreRunPropertiesUtils.EDGE_BROWSER.toLowerCase().trim());
        switch (PreRunPropertiesUtils.EDGE_BROWSER.toLowerCase().trim()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
    }
}
