package StepDefinitions;

import PreRunnerClasses.PreRunnerUtils;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PreRunnerScript {
    public static WebDriver driver;

    @Before
    public void beforeScenario(){
        PreRunnerUtils.readConfigFiles();
        try {
            launchBrowser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void launchBrowser() {

        switch (PreRunnerUtils.EDGE_BROWSER.toLowerCase().trim()){
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
