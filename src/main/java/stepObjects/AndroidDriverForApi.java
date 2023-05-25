package stepObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.helpers.CheckReturnValue;

import javax.annotation.ParametersAreNonnullByDefault;
import java.net.URL;


@ParametersAreNonnullByDefault
public class AndroidDriverForApi {
    public AppiumDriver driver;

    @CheckReturnValue
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "SM-G955FD");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("no-reset", "false");
        capabilities.setCapability("full-reset", "true");
        capabilities.setCapability("appPackage", "com.reddit.frontpage");
        capabilities.setCapability("appActivity",
                "com.reddit.frontpage.StartActivity");
        try {
            driver = new AndroidDriver(new URL(
                    "http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }

    }


}
