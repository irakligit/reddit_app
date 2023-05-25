package pageObjects.reditAppPage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RedditAppPage {
    AppiumDriver driver;

    public RedditAppPage(AppiumDriver driver) {
        this.driver = driver;
    }
    @Step("explicit wait")
    public WebElement explicitWait(By element, int duration) {
        return new WebDriverWait(driver, Duration.ofSeconds(duration))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    private final By skipButton = By.xpath("//android.widget.Button");
    private final By searchIcon = By.id("com.reddit.frontpage:id/feed_control_search_icon");
    private final By searchField = By.id("com.reddit.frontpage:id/search");
    private final By clickSearchOrResultsButton = By.xpath("//*[@resource-id='com.reddit.frontpage:id/typeahead_results_container']//*[contains(@text,'Results for') or contains(@text,'Search for')]");
    private final By sortButton = By.xpath("//*[@resource-id='com.reddit.frontpage:id/search_results']//*[@text='Sort']");
    private final By hotButton = By.xpath("//*[@resource-id='com.reddit.frontpage:id/search_filters_recycler_view']//*[@text='Hot']");
    private final By allPost = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.reddit.frontpage:id/search_results']/android.view.ViewGroup");
    private final By pageName = By.xpath("//*[@resource-id='com.reddit.frontpage:id/subreddit_title']");
    private final By user = By.xpath("//*[@resource-id='com.reddit.frontpage:id/poster_username']");
    private final By publishTime = By.xpath("//*[@resource-id='com.reddit.frontpage:id/time_since']");
    private final By upVotes = By.xpath("//*[@resource-id='com.reddit.frontpage:id/upvotes']");
    private final By numberOfComments = By.xpath("//*[@resource-id='com.reddit.frontpage:id/comments']");
    private final By loginWithGoogle = By.xpath("//*[@text='Continue with Google']");
    private final By firstEmail = By.xpath("//*[@resource-id='com.google.android.gms:id/list']/android.widget.LinearLayout[1]");
    private final AppiumBy scrollDown = new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollToEnd(1)");
    private final By loader = By.xpath("//android.widget.ProgressBar");

    public By getLoader() {
        return loader;
    }

    public WebElement getFirstEmail() {
        return explicitWait(firstEmail, 15);
    }

    public WebElement getLoginWithGoogle() {
        return driver.findElement(loginWithGoogle);
    }

    public By getNumberOfComments() {

        return numberOfComments;
    }

    public By getUpVotes() {

        return upVotes;
    }

    public By getPublishTime() {

        return publishTime;
    }

    public By getUser() {

        return user;
    }

    public By getPageName() {
        explicitWait(pageName, 15);
        return pageName;
    }

    public WebElement getScrollDown() {
        return driver.findElement(scrollDown);
    }

    public List<WebElement> getAllPost() {
        explicitWait(allPost, 15);
        return driver.findElements(allPost);
    }

    public WebElement getHotButton() {
        return explicitWait(hotButton, 15);
    }

    public WebElement getSortButton() {
        return explicitWait(sortButton, 15);
    }


    public WebElement getSearchIcon() {
        return explicitWait(searchIcon, 20);
    }

    public WebElement getSearchField() {
        return driver.findElement(searchField);
    }

    public WebElement getSkipButton() {
        return driver.findElement(skipButton);
    }

    public WebElement getClickSearchOrResultsButton() {
        return explicitWait(clickSearchOrResultsButton, 15);
    }

}

