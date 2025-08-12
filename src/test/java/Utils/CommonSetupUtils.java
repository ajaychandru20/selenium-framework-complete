package Utils;

import HMRC.Logins.DashboardPage;
import HMRC.Logins.DirectoryPage;
import HMRC.Logins.LoginPage;
import StepDefinitions.DirectorySteps;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CommonSetupUtils {

    public static String APP_URL;
    public static String BROWSER;
    public static String USERNAME;
    public static String PASSWORD;
    public static String EDGE_BROWSER;
    public static String FIREFOX_BROWSER;
    public static String CHROME_BROWSER;

    private static String scenarioName = null;
    private static CommonSetupUtils commonSetupUtilsInstance;
    private static final Logger logger = LogManager.getLogger(CommonSetupUtils.class);

    private CommonSetupUtils() {
    }

    public static CommonSetupUtils getInstance() {
        if (commonSetupUtilsInstance == null) {
            commonSetupUtilsInstance = new CommonSetupUtils();
        }
        return commonSetupUtilsInstance;
    }

    public static void setScenarioName(String name) {
        scenarioName = name;
    }

    public static String getScenarioName() {
        return scenarioName;
    }

    public void readConfigFiles() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
            APP_URL = properties.getProperty("APP_URL");
            BROWSER = properties.getProperty("BROWSER");
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");
            EDGE_BROWSER = properties.getProperty("EDGE_BROWSER");
            FIREFOX_BROWSER = properties.getProperty("FIREFOX_BROWSER");
            CHROME_BROWSER = properties.getProperty("CHROME_BROWSER");
            logger.info("Properties data are run successfully");
        } catch (Exception e) {
            logger.error("Failed to load config.properties", e);
        }
    }

    public void initWebElements() {
        PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), DashboardPage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
    }

    public void takeScreenShot() {
        try {
            if (DriverManager.getDriver() == null) {
                logger.warn("WebDriver is null. Cannot take screenshot.");
                return;
            }

            String scenario = getScenarioName() != null ? getScenarioName() : "UnknownScenario";
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String folderPath = "src/test/resources/ScreenShots/";
            File directory = new File(folderPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile = new File(folderPath + scenario + "_" + timestamp + ".png");
            FileUtils.copyFile(screenshot, destFile);
            logger.info("Screenshot saved: " + destFile.getPath());
        } catch (Exception e) {
            logger.error("Error while taking screenshot", e);
        }
    }


    public void selectDropDown(WebElement webelement, String howTo, String value) {

        Select select = new Select(webelement);
        switch (howTo) {
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            default:
                logger.info("Please select the valid dropdown format, like text, index or value.");
                break;
        }

    }
}
