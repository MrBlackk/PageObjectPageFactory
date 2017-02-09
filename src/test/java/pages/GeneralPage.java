package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Log4Test;

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
        Log4Test.test("Open " + url + " url");
        webDriver.get(url);
    }
}
