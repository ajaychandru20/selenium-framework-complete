package HMRC.Logins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {

    private static DashboardPage dashboardPageInstance;
    private DashboardPage(){
    }
    public static DashboardPage getInstance(){

        if (dashboardPageInstance == null){
            dashboardPageInstance = new DashboardPage();
        }
        return dashboardPageInstance;
    }

    @FindBy(css = ".oxd-topbar-header-title")
    public static WebElement DashboardTitle;
}
