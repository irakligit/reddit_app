package stepObjects.reditSteps;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import pageObjects.reditAppPage.RedditAppPage;

public class RedditAppUiSteps {
    RedditAppPage redditAppPage;

    AppiumDriver driver;

    public RedditAppUiSteps(AppiumDriver driver) {
        redditAppPage = new RedditAppPage(driver);
        this.driver = driver;
    }

    @Step("login")
    public RedditAppUiSteps login() {
        try {
            redditAppPage.getSkipButton().click();

        } catch (Exception e) {
            try {
                redditAppPage.getSearchIcon();
            } catch (Exception j) {

                redditAppPage.getLoginWithGoogle().click();
                redditAppPage.getFirstEmail().click();
            }

        }
        return this;
    }



    @Step("Click search icon")
    public RedditAppUiSteps clickSearchIcon() {
        redditAppPage.getSearchIcon().click();
        return this;
    }

    @Step("Enter banking text in the search field")
    public RedditAppUiSteps enterBankingTextInTheSearchField() {
        redditAppPage.getSearchField().sendKeys("Banking");

        return this;

    }

    @Step("Click result for banking")
    public RedditAppUiSteps clickSearchOrResultsButton() throws InterruptedException {

        redditAppPage.getClickSearchOrResultsButton().click();

        return this;
    }

    @Step("Click sort button")
    public RedditAppUiSteps clickSortButton() {
        redditAppPage.getSortButton().click();
        return this;
    }

    @Step("Click hot radioButton")
    public RedditAppUiSteps clickHotRadioButton() {
        redditAppPage.getHotButton().click();
        return this;
    }
}
