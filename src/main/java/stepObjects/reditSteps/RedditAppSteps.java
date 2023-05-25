package stepObjects.reditSteps;

import dataObjects.NewsData;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.reditAppPage.RedditAppPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RedditAppSteps {
    RedditAppPage redditAppPage;
    AppiumDriver driver;

    public RedditAppSteps(AppiumDriver driver) {
        redditAppPage = new RedditAppPage(driver);
        this.driver = driver;
    }


    @Step("extract data")
    public RedditAppSteps extractData(List<WebElement> data, ArrayList<NewsData> allData, int maxNews, boolean ignoreFirstContainer) {
        if (data.size() != 0 && ignoreFirstContainer)
            data.remove(0);

        for (WebElement container : data
        ) {
            try {
                if (allData.size() == maxNews)
                    break;
                String pageName = container.findElement(redditAppPage.getPageName()).getText();
                String user = container.findElement(redditAppPage.getUser()).getText();
                String publishTime = container.findElement(redditAppPage.getPublishTime()).getText();
                String upVotes = container.findElement(redditAppPage.getUpVotes()).getText();
                String numberOfComments = container.findElement(redditAppPage.getNumberOfComments()).getText();
                allData.add(
                        new NewsData(
                                Integer.parseInt(upVotes.split(" ")[0]),
                                Integer.parseInt(numberOfComments.split(" ")[0]),
                                pageName, user, publishTime
                        )

                );

            } catch (Exception ignored) {
            }
        }
        return this;
    }

    @Step("explicit wait for news to load ")
    public RedditAppSteps waitNewsLoad(int duration) {
        WebElement loaderElement = null;
        try {
            loaderElement = new WebDriverWait(driver, Duration.ofSeconds(duration))
                    .until(ExpectedConditions.visibilityOfElementLocated(redditAppPage.getLoader()));
        } catch (Exception ignored) {}

        try {
            if (loaderElement != null)
                new WebDriverWait(driver, Duration.ofSeconds(duration))
                        .until(ExpectedConditions.invisibilityOf(loaderElement));
        } catch (Exception ignored) {}
        return this;
    }

    @Step("Get the post with the most upVotes")
    public RedditAppSteps GetThePostWithTheMostUpVotes(int maxNews){
        ArrayList<NewsData> data = new ArrayList<>();
        waitNewsLoad(5);
        extractData(redditAppPage.getAllPost(), data, maxNews, true);
        while (data.size() != maxNews) {
            redditAppPage.getScrollDown();
            extractData(redditAppPage.getAllPost(), data, maxNews, false);
        }
        data.sort(Collections.reverseOrder());
        NewsData newsWithMostUpVotes = data.get(0);
        System.out.println("The post with the most upVotes:");
        System.out.println("page name: " + newsWithMostUpVotes.getPageName());
        System.out.println("user: " + newsWithMostUpVotes.getUser());
        System.out.println("post publication time: " + newsWithMostUpVotes.getPublishName());
        System.out.println("upVotes number: " + newsWithMostUpVotes.getUpVotes());
        System.out.println("number of comments: " + newsWithMostUpVotes.getNumberOfComments());
        return this;
    }

}
