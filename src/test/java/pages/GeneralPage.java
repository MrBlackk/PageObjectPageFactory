package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by chv on 02.02.2017.
 *
 * General Page
 */
abstract class GeneralPage {

    protected WebDriver webDriver;

    public GeneralPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Open specified url
     */
    public void open(String url) {
        webDriver.get(url);
    }
}
