package HMRC.Logins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.DriverManager;
import java.time.Duration;

public class LoginPage {


    @FindBy(name = "username")
    public static WebElement USERNAME;

    @FindBy(name = "password")
    public static WebElement PASSWORD;


    @FindBy(css = "button[type='submit']")
    public static WebElement SUBMIT;
}
