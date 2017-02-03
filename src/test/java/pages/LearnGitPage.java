package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 03.02.2017.
 *
 * Learn Git page
 */
public class LearnGitPage extends GeneralPage {

    @FindBy(className = "shelf-title")
    private WebElement learnGit;
    @FindBy(linkText = "Start a project")
    private WebElement startProjectButton;

    public LearnGitPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Get Learn Git text
     */
    public String getLearnGitText(){
        return learnGit.getText();
    }

    /**
     * Click Start a Project button to open Create New Repository page
     */
    public CreateNewRepoPage openCreateNewRepositoryPage(){
        startProjectButton.click();
        return new CreateNewRepoPage(webDriver);
    }
}
