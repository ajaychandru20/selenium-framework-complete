package StepDefinitions;

import HMRC.Logins.DirectoryPage;
import Utils.CommonSetupUtils;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

public class DirectorySteps {
    Logger logger = LogManager.getLogger(DirectorySteps.class);
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

    @And("select the Directory navbar, check the field names")
    public void select_the_directory_navbar_check_the_field_names() {
        try {
            logger.info("Selecting the Directory navbar...");
            wait.until(ExpectedConditions.visibilityOf(DirectoryPage.getInstance().getDirectoryNavbar()));
            DirectoryPage.getInstance().getDirectoryNavbar().click();

            logger.info("Waiting for the Directory title bar to be visible.");
            wait.until(ExpectedConditions.visibilityOf(DirectoryPage.getInstance().DirectoryTitleBar));
            String actualDirectoryHeader = DirectoryPage.getInstance().DirectoryTitleBar.getText();
            logger.info("Fetched Directory title: '{}'", actualDirectoryHeader);
            assertEquals("Directory", actualDirectoryHeader, "The field does not contain 'Directory'");
            logger.info("Assertion passed: Directory title is correct.");

            logger.info("Waiting for Employee Name header to be visible.");
            wait.until(ExpectedConditions.visibilityOf(DirectoryPage.getInstance().getEmployeeNameHeader()));
            String actualEmpHeader = DirectoryPage.getInstance().getEmployeeNameHeader().getText();
            logger.info("Fetched Employee Name header: '{}'", actualEmpHeader);
            assertEquals("Employee Name", actualEmpHeader, "The field does not contain 'Employee Name'");
            logger.info("Assertion passed: Employee Name header is correct.");

            logger.info("Waiting for Job Title header to be visible.");
            wait.until(ExpectedConditions.visibilityOf(DirectoryPage.getInstance().JobTitleDropdown));
            String actualJobTitleHeader = DirectoryPage.getInstance().getJobTitleHeader().getText();
            logger.info("Fetched Job Title header: '{}'", actualJobTitleHeader);
            assertEquals("Job Title", actualJobTitleHeader, "The field does not contain 'Job Title'");
            logger.info("Assertion passed: Job Title header is correct.");

            logger.info("Waiting for Location header to be visible.");
            wait.until(ExpectedConditions.visibilityOf(DirectoryPage.getInstance().getLocationHeader()));
            String actualLocationHeader = DirectoryPage.getInstance().getLocationHeader().getText();
            logger.info("Fetched Location header: '{}'", actualLocationHeader);
            assertEquals("Location", actualLocationHeader, "The field does not contain 'Location'");
            logger.info("Assertion passed: Location header is correct.");

        } catch (AssertionError ae) {
            logger.error("Assertion failed: " + ae.getMessage());
//            CommonSetupUtils.getInstance().takeScreenShot();
            Assert.fail(ae.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: ", e);
//            CommonSetupUtils.getInstance().takeScreenShot();
            Assert.fail(e.getMessage());
        }
    }


    @Then("select the employee role {string} in the job title dropdown using {string}")
    public void select_the_employee_role_in_the_job_title_dropdown(String JobRole, String howToSelectDropdown) {

        try {
            logger.info("Select the Employee Role in the Dropdown");
            wait.until(ExpectedConditions.visibilityOf(DirectoryPage.getInstance().getJobTitleDropdown()));
            DirectoryPage.getInstance().getJobTitleDropdown().click();
//            CommonSetupUtils.getInstance().selectDropDown(DirectoryPage.getInstance().getJobTitleDropdown(), howToSelectDropdown, JobRole);
            List<WebElement> options = DriverManager.getDriver().findElements(By.className("oxd-select-option"));
            if (!options.isEmpty()){
                for (WebElement option : options) {
                    if (option.getText().equalsIgnoreCase(JobRole)) {
                        logger.info("Selected Employee Role is: " + option.getText());
                        option.click();
                        Thread.sleep(2000);
                        break;
                    }
                }
            }else{
                logger.error("Option dropdown not selected So No records found in Options");
//                CommonSetupUtils.getInstance().takeScreenShot();
                Assert.fail("No records found in Options");
            }

        } catch (Exception e) {
            logger.error(e);
//            CommonSetupUtils.getInstance().takeScreenShot();
            Assert.fail(e.getMessage());
        }

        DirectoryPage.getInstance().getSearchButton().click();

        DriverManager.getDriver().quit();

    }
}
