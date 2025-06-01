package HMRC.Logins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    @FindBy(css = ".oxd-topbar-header-title")
    public static WebElement DashboardTitle;
}
