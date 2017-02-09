package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

/**
 * Created by chv on 02.02.2017.
 *
 * Home page
 */
public class HomePage extends GeneralPage {

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Click Sign In button to open Sign In page
     */
    public SignInPage openSignInPage() {
        Log4Test.test("Click Sign In button on header");
        signInButton.click();
        return new SignInPage(webDriver);
    }
}
