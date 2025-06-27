package HMRC.Logins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;

public class LoginPage {
    private static LoginPage loginPageInstance;
    private LoginPage(){

    }
    public static LoginPage getInstance(){
        if (loginPageInstance == null){
            loginPageInstance = new LoginPage();
        }
        return loginPageInstance;
    }

    @FindBy(name = "username")
    private WebElement USERNAME;

    @FindBy(name = "password")
    public static WebElement PASSWORD;


    @FindBy(css = "button[type='submit']")
    private WebElement SUBMIT;

    public WebElement getUSERNAME() {
        return USERNAME;
    }

    public WebElement getPASSWORD() {
        return PASSWORD;
    }

    public WebElement getSUBMIT() {
        return SUBMIT;
    }
}
