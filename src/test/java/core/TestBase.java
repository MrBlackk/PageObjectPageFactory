package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by chv on 02.02.2017.
 *
 * Test Base class
 */
public abstract class TestBase {
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;

    @BeforeClass
    protected void setUp() throws MalformedURLException {
        threadDriver = new ThreadLocal<RemoteWebDriver>();
        DesiredCapabilities dc = new DesiredCapabilities().chrome();
        dc.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
        threadDriver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc)); // hub url with at least two nodes to run in parallel

        getDriver().manage().window().maximize();

        //default timeouts
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        getDriver().manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    /**
     * Get driver instance
     */
    public WebDriver getDriver(){
        return threadDriver.get();
    }

    @AfterClass
    protected void tearDown() {
        getDriver().quit();
    }
}
