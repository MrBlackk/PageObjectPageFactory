package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by chv on 03.02.2017.
 *
 * Create New Repository page
 */
public class CreateNewRepoPage extends GeneralPage {

    @FindBy(className = "Subhead-heading")
    private WebElement createNewRepo;

    public CreateNewRepoPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Get Create New Repository Text
     */
    public String getCreateNewRepo() {
        return createNewRepo.getText();
    }
}
