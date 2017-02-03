package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 02.02.2017.
 *
 * Sign In page
 */
public class SignInPage extends GeneralPage {

    @FindBy(id = "login_field")
    private WebElement usernameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(name = "commit")
    private WebElement signInButton;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Sign In to Github with login and password
     */
    public LearnGitPage signInToGithub(String login, String password){
        usernameInput.clear();
        usernameInput.sendKeys(login);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        signInButton.click();

        return new LearnGitPage(webDriver);
    }
}
