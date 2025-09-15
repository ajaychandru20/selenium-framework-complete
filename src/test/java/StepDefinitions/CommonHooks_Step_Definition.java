package StepDefinitions;

import HMRC.Logins.LoginPage;
import Utils.CommonSetupUtils;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonHooks_Step_Definition {

    private static final Logger logger = LogManager.getLogger(CommonHooks_Step_Definition.class);
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(15));

    @Before
    public void beforeScenario(Scenario scenario) {
        CommonSetupUtils.setScenarioName(scenario.getName());
        logger.info("BeforeHooks---------------------------------------------------");
        logger.info("Running BeforeScenario for scenario: " + scenario.getName());

        CommonSetupUtils.getInstance().readConfigFiles();

        try {
            if (DriverManager.getDriver() == null) {
                logger.info("Launching browser from Common_Step_Definition...");
                DriverManager.launchBrowser();
                CommonSetupUtils.getInstance().initWebElements();

                logger.info("Platform navigates to login page");
                DriverManager.getDriver().get(CommonSetupUtils.APP_URL);


                logger.info("Entering the credentials username and password");
                wait.until(ExpectedConditions.visibilityOf(LoginPage.getInstance().getUSERNAME()));
                LoginPage.getInstance().getUSERNAME().sendKeys(CommonSetupUtils.USERNAME);
                wait.until(ExpectedConditions.visibilityOf(LoginPage.getInstance().getPASSWORD()));
                LoginPage.getInstance().getPASSWORD().sendKeys(CommonSetupUtils.PASSWORD);
                LoginPage.getInstance().getSUBMIT().click();
                logger.info("Credentials Working fine, login into platform");


            }
        } catch (Exception e) {
            logger.error("Error during browser setup", e);
            throw new RuntimeException(e);
        }
    }
    @AfterStep
    public void attachScreenShot(Scenario scenario){
        if(scenario.isFailed()){
            byte [] screenShotTaken=
                    ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShotTaken,"image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(Scenario scenario){
        CommonSetupUtils.setScenarioName(scenario.getName());
        logger.info("Browser Close after all test scenarios.");
        if(DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
        }

    }
}
