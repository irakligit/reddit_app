package reditApp;

import io.qameta.allure.Description;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stepObjects.AndroidDriverForApi;
import stepObjects.reditSteps.RedditAppSteps;
import stepObjects.reditSteps.RedditAppUiSteps;


public class RedditAppTest extends AndroidDriverForApi {
    RedditAppSteps redditAppSteps;
    RedditAppUiSteps redditAppUiSteps;


    @BeforeMethod
    public void beforeMethod() {
        setUp();
        redditAppSteps = new RedditAppSteps(driver);
        redditAppUiSteps = new RedditAppUiSteps(driver);
        redditAppUiSteps.login();
    }

    @Test
    @Description("Get the post with the most upvotes")
    public void SortTheRedditAppsNewsList() throws InterruptedException {
        redditAppUiSteps
                .clickSearchIcon()
                .enterBankingTextInTheSearchField()
                .clickSearchOrResultsButton()
                .clickSortButton()
                .clickHotRadioButton();
        redditAppSteps.GetThePostWithTheMostUpVotes(20);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
