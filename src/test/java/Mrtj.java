import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.Utils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
        MobileElement serviceSearch = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/search_view");
        serviceSearch.click();
        Utils.delay(5);
        MobileElement services = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/search_view");
        services.sendKeys("public transport");
        Utils.delay(5);
        MobileElement publicTransport = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/info_view");
        publicTransport.click();
        Utils.delay(5);
        MobileElement mrtj = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/item_view");
        mrtj.click();
        Utils.delay(5);
        MobileElement route = (MobileElement) driver.findElementById("id.go.jakarta.smartcity.jaki:id/code_view");
        route.click();

        List<MobileElement> listOfRoute = driver.findElements(MobileBy.xpath("(//div[@class='android.widget.LinearLayout']"));

        for (int i = 0; i < listOfRoute.size(); i++) {
            System.out.println(listOfRoute.get(i).getText());

        }


//        MobileElement route = (MobileElement) driver.findElementByXPath("//android.widget.LinearLayout[@resource-id='id.go.jakarta.smartcity.jaki:id/expanded_header']");
//        String txtRoute = route.getText();
//        System.out.println(txtRoute);
    }

}
