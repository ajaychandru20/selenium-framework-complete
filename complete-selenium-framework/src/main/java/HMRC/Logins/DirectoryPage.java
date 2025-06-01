package HMRC.Logins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DirectoryPage {

    @FindBy(linkText = "Directory")
    public static WebElement DirectoryNavbar;

    @FindBy(css = ".oxd-topbar-header-breadcrumb-module")
    public static WebElement DirectoryTitleBar;

    @FindBy(xpath = "//label[normalize-space()='Employee Name']")
    public static WebElement EmployeeNameHeader;

    @FindBy(xpath = "//label[normalize-space()='Job Title']")
    public static WebElement JobTitleHeader;

    @FindBy(xpath = "//label[normalize-space()='Location']")
    public static WebElement LocationHeader;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text-input\"])[1]")
    public static WebElement JobTitleDropdown;

    @FindBy(xpath = "(//div[@class=\"oxd-select-text-input\"])[2]")
    public static WebElement LocationDropDown;

    @FindBy(css = "button[type='submit']")
    public static WebElement SearchButton;


}
