package HMRC.Logins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {

    public static DirectoryPage homePageInstance;

    private DirectoryPage() {

    }

    public static DirectoryPage getInstance() {

        if (homePageInstance == null) {
            homePageInstance = new DirectoryPage();
        }
        return homePageInstance;

    }


    @FindBy(linkText = "Directory")
    public WebElement DirectoryNavbar;

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    public WebElement DirectoryTitleBar;

    @FindBy(xpath = "//label[normalize-space()='Employee Name']")
    public WebElement EmployeeNameHeader;

    @FindBy(xpath = "//label[normalize-space()='Job Title']")
    public WebElement JobTitleHeader;

    @FindBy(xpath = "//label[normalize-space()='Location']")
    public WebElement LocationHeader;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text-input\"])[1]")
    public WebElement JobTitleDropdown;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text-input\"])[2]")
    public WebElement LocationDropDown;

    @FindBy(css = "button[type='submit']")
    public WebElement SearchButton;

    public WebElement getDirectoryNavbar() {
        return DirectoryNavbar;
    }

    public WebElement getDirectoryTitleBar() {
        return DirectoryTitleBar;
    }

    public WebElement getEmployeeNameHeader() {
        return EmployeeNameHeader;
    }

    public WebElement getJobTitleHeader() {
        return JobTitleHeader;
    }

    public WebElement getLocationHeader() {
        return LocationHeader;
    }

    public WebElement getJobTitleDropdown() {
        return JobTitleDropdown;
    }

    public WebElement getLocationDropDown() {
        return LocationDropDown;
    }

    public WebElement getSearchButton() {
        return SearchButton;
    }


}
