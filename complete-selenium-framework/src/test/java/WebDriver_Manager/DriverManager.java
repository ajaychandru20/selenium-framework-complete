package WebDriver_Manager;

import PreRunnerClasses.PreRunPropertiesUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;

public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static WebDriver driver = null;

    public static void launchBrowser() {
        try {
            logger.info("The Browser Selected: " + PreRunPropertiesUtils.EDGE_BROWSER.toLowerCase().trim());
            switch (PreRunPropertiesUtils.EDGE_BROWSER.toLowerCase().trim()) {
                case "chrome":
                    chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
                case "firefox":
                    firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
                case "edge":
                    edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;
                default:
                    chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static WebDriver getDriver(){
        return driver;
    }

}
