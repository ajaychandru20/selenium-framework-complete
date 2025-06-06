package PreRunnerClasses;

import HMRC.Logins.DashboardPage;
import HMRC.Logins.DirectoryPage;
import HMRC.Logins.LoginPage;
import WebDriver_Manager.DriverManager;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class PreRunPropertiesUtils {

    public static String APP_URL;
    public static String BROWSER;
    public static String USERNAME;
    public static String PASSWORD;
    public static String EDGE_BROWSER;
    public static String FIREFOX_BROWSER;
    public static String CHROME_BROWSER;

    public void readConfigFiles(){
        Properties properties = new Properties();
        try {
        properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            APP_URL = properties.getProperty("APP_URL");
            BROWSER = properties.getProperty("BROWSER");
            USERNAME = properties.getProperty("USERNAME");
            PASSWORD = properties.getProperty("PASSWORD");
            EDGE_BROWSER = properties.getProperty("EDGE_BROWSER");
            FIREFOX_BROWSER = properties.getProperty("FIREFOX_BROWSER");
            CHROME_BROWSER = properties.getProperty("CHROME_BROWSER");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void initWebElements(){
        PageFactory.initElements(DriverManager.getDriver(), LoginPage.class);
        PageFactory.initElements(DriverManager.getDriver(), DashboardPage.class);
        PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.class);
    }

}
