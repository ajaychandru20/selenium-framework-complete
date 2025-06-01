package StepDefinitions;

import HMRC.Logins.DirectoryPage;
import WebDriver_Manager.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

public class DirectorySteps {
    Logger logger = LogManager.getLogger(DirectorySteps.class);
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

    @And("select the Directory navbar, check the field names")
    public void select_the_directory_navbar_check_the_field_names() {
        logger.info("select the Navbar Directory");
        wait.until(ExpectedConditions.visibilityOf(DirectoryPage.DirectoryNavbar));
        DirectoryPage.DirectoryNavbar.click();

        // Log: Waiting for Directory title to be visible
        logger.info("Waiting for the Directory title bar to be visible.");
        wait.until(ExpectedConditions.visibilityOf(DirectoryPage.DirectoryTitleBar));

        // Get and log the actual header text
        String actualDirectoryHeader = DirectoryPage.DirectoryTitleBar.getText();
        logger.info("Fetched Directory title: '{}'", actualDirectoryHeader);

        // Assert and log result
        assertEquals("Directory", actualDirectoryHeader, "The field does not contain 'Directory'");
        logger.info("Assertion passed: Directory title is correct.");

        // Log: Waiting for Employee Name header to be visible
        logger.info("Waiting for Employee Name header to be visible.");
        wait.until(ExpectedConditions.visibilityOf(DirectoryPage.EmployeeNameHeader));

        // Get and log the actual employee header
        String actualEmpHeader = DirectoryPage.EmployeeNameHeader.getText();
        logger.info("Fetched Employee Name header: '{}'", actualEmpHeader);

        // Assert and log result
        assertEquals("Employee Name", actualEmpHeader, "The field does not contain 'Employee Name'");
        logger.info("Assertion passed: Employee Name header is correct.");


        wait.until((ExpectedConditions.visibilityOf(DirectoryPage.JobTitleHeader)));
        String ActualJobTitleHeader = DirectoryPage.JobTitleHeader.getText();
        assertEquals("Job Title", ActualJobTitleHeader, "The Field does not contain, Job Title");
        logger.info("Assertion passed: Job Title header is correct.");

        wait.until((ExpectedConditions.visibilityOf(DirectoryPage.LocationHeader)));
        String ActualLocationHeader = DirectoryPage.LocationHeader.getText();
        assertEquals("Location", ActualLocationHeader, "The Field does not contain, Location");
        logger.info("Assertion passed: Location header is correct.");

    }


    @Then("select the employee role {string} in the job title dropdown")
    public void select_the_employee_role_in_the_job_title_dropdown(String JobRole) {

        logger.info("Select the Employee Role in the Dropdown");
        wait.until(ExpectedConditions.visibilityOf(DirectoryPage.JobTitleDropdown));
        DirectoryPage.JobTitleDropdown.click();
        List<WebElement> options = DriverManager.getDriver().findElements(By.className("oxd-select-option"));
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(JobRole)) {
                logger.info("Selected Employee Role is: '{}'", option.getText());
                option.click();
                break;
                                                                                                                                                                                                                            }
        }

        DirectoryPage.SearchButton.click();

        DriverManager.getDriver().quit();


    }
}
