import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.Utils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class HomeScreen {

    AndroidDriver driver;

    @BeforeClass
    public void setUp () throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 2 API 30");
        dc.setCapability("udid", "emulator-5554");
        dc.setCapability("platformName", "android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability("appPackage", "id.go.jakarta.smartcity.jaki");
        dc.setCapability("appActivity", "id.go.jakarta.smartcity.jaki.home.SplashActivity");
        dc.setCapability("noReset", true);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, dc);
    }

    @AfterClass
    public void finish () {
        Utils.delay(3);
        driver.quit();
    }

    @org.junit.Test
    @Test
    public void testHomeScreen() {
        Utils.delay(5);
    }
}
