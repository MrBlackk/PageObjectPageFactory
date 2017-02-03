package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tests.TestData;

import java.util.concurrent.TimeUnit;

/**
 * Created by chv on 02.02.2017.
 *
 * Test Base class
 */
public abstract class TestBase {
    protected static WebDriver webDriver;
    protected static WebDriverWait wait;


    @BeforeSuite
    protected void setUp() {
        webDriver = WebDriverFactory.getWebDriver(TestData.BROWSER_NAME);
        wait = new WebDriverWait(webDriver, 10);

        webDriver.manage().window().maximize();

        //default timeouts
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @AfterSuite
    protected void tearDown() {
        webDriver.quit();
    }
}
