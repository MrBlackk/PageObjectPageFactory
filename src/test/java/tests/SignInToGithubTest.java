package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LearnGitPage;
import utils.Log4Test;

/**
 * Created by chv on 02.02.2017.
 *
 * Test to check Signing In to Github
 */
public class SignInToGithubTest extends TestBase {

    @Test(description = "Open Github page")
    public void openUrl() {
        Log4Test.test("Open Github page");
        new HomePage(webDriver)
                .open(TestData.GITHUB_URL);
    }

    @Test(dependsOnMethods = "openUrl", description = "Sign In to Github and check Learn Github page")
    public void signInToGithub() {
        if (TestData.GITHUB_LOGIN.equals("") || TestData.GITHUB_PASS.equals("")) {
            Assert.fail("Login or password is empty, Please check TestData class");
        }

        Log4Test.test("Signing in to Github");
        String learnGit = new HomePage(webDriver)
                .openSignInPage()
                .signInToGithub(TestData.GITHUB_LOGIN, TestData.GITHUB_PASS)
                .getLearnGitText();

        Log4Test.test("Checking Learn Github message");
        Assert.assertEquals(learnGit, TestData.LEARN_GIT_EXPECTED, "Learn Git message is not correct");
    }

    @Test(dependsOnMethods = "signInToGithub", description = "Open Create New Repository page")
    public void openCreateNewRepoPage() {
        Log4Test.test("Open Create New Repository Page");
        String createNewText = new LearnGitPage(webDriver)
                .openCreateNewRepositoryPage()
                .getCreateNewRepo();

        Assert.assertEquals(createNewText, TestData.CREATE_NEW_REPO_EXPECTED, "Learn Git message is not correct");
    }
}
