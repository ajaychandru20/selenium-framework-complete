package PreRunnerClasses;

import java.io.FileReader;
import java.util.Properties;

public class PreRunnerUtils {

    public static String APP_URL;
    public static String BROWSER;
    public static String USERNAME;
    public static String PASSWORD;
    public static String EDGE_BROWSER;
    public static String FIREFOX_BROWSER;
    public static String CHROME_BROWSER;

    public static void readConfigFiles(){
        FileReader reader = null;
        try {
            reader = new FileReader("config.properties");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Properties properties = new Properties();
            properties.load(reader);
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

}
