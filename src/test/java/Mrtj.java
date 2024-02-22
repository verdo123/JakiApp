import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.Utils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Mrtj {
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
    public void testMrtj(){
        Utils.delay(5);
        MobileElement serviceSearch = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Looking for Services?']");
        serviceSearch.click();
        Utils.delay(2);
        MobileElement services = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/search_view");
        services.sendKeys("public transport");
        Utils.delay(5);
        MobileElement publicTransport = (MobileElement) driver.findElementByXPath("//androidx.recyclerview.widget.RecyclerView[@resource-id='id.go.jakarta.smartcity.jaki:id/search_result_recycler']/android.widget.LinearLayout[2]");
        publicTransport.click();
        Utils.delay(5);
        MobileElement mrtj = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/item_view");
        mrtj.click();
        Utils.delay(5);

    }

}
