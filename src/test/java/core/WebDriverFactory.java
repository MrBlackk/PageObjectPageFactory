package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by chv on 02.02.2017.
 *
 * WebDriver Factory
 */
public class WebDriverFactory {

    static {
        try {
            System.setProperty("webdriver.chrome.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe").getPath());
            System.setProperty("webdriver.gecko.driver", WebDriverFactory.class.getClassLoader().getResource("drivers/geckodriver.exe").getPath());
        } catch (Exception ex) {
            System.out.println("Cannot launch Chrome or Firefox driver \n" + ex.getMessage());
        }
    }

    public static WebDriver getWebDriver(BrowserTypes browserType) {
        switch (browserType) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Browser is not supported " + browserType);
        }
    }
}
