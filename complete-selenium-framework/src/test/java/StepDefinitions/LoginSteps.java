package StepDefinitions;

import HMRC.Logins.DashboardPage;
import HMRC.Logins.LoginPage;
import Utils.CommonSetupUtils;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    WebDriver driver = DriverManager.getDriver();
//    LoginPage loginPage = new LoginPage(driver); // initialize elements
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    Logger logger = LogManager.getLogger(LoginSteps.class);

    @Given("platform navigates to login page")
    public void platform_navigates_to_login_page() {
        logger.info("Platform navigates to login page");
        driver.get(CommonSetupUtils.APP_URL);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {

        logger.info("Entering the credentials username and password");
        wait.until(ExpectedConditions.visibilityOf(LoginPage.USERNAME));
        LoginPage.USERNAME.sendKeys(CommonSetupUtils.USERNAME);
        wait.until(ExpectedConditions.visibilityOf(LoginPage.PASSWORD));
        LoginPage.PASSWORD.sendKeys(CommonSetupUtils.PASSWORD);
        LoginPage.SUBMIT.click();
        logger.info("Credentials Working fine, login into platform");
    }

    @Then("platform allows the user login, and navigate to dashboard")
    public void user_is_navigated_to_the_homepage() {

        wait.until(ExpectedConditions.visibilityOf(DashboardPage.DashboardTitle));
        String DashboardTitleText = DashboardPage.DashboardTitle.getText();
        String DashboardURLText = DriverManager.getDriver().getCurrentUrl();
        if (DashboardTitleText.contains("Dashboard") && DashboardURLText.contains("dashboard")){
            logger.info("The url contains dashboard");
            logger.info("The Dashboard Title is visible also contains the text");
        }
    }
}
