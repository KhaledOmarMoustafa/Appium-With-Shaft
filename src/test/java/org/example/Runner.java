package org.example;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Runner {

    static SHAFT.GUI.WebDriver driver;
    @Test
    public void openBrowser() throws MalformedURLException, InterruptedException {
        //  WebDriverManager.chromedriver().setup();
/*
        UiAutomator2Options ai = new UiAutomator2Options().setUdid("emulator-5554");
        ai.setCapability("appPackage","com.swaglabsmobileapp");
        ai.setCapability("appActivity","com.swaglabsmobileapp.MainActivity");
*/



        SHAFT.Properties.mobile.set().automationName(AutomationName.ANDROID_UIAUTOMATOR2);
        SHAFT.Properties.platform.set().targetPlatform("Android");
        SHAFT.Properties.platform.set().executionAddress("localhost:4723");
        SHAFT.Properties.browserStack.set().deviceName("DeviceOne");
        /*SHAFT.Properties.mobile.set().appPackage("io.appium.android.apis");
        SHAFT.Properties.mobile.set().appActivity("io.appium.android.apis.ApiDemos");*/
        SHAFT.Properties.mobile.set().app("src/test/resources/testDataFiles/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");


        driver = new SHAFT.GUI.WebDriver();
        //  driver.browser().maximizeWindow();


        By userName = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]\n");
        driver.element().type(userName,"standard_user");

        By passWord = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]\n");
        driver.element().type(passWord,"secret_sauce");

        By login = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView\n");
        driver.element().click(login);


        By addFirstItem = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView\n");
        driver.element().click(addFirstItem);

        By sort = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView\n");
        driver.element().click(sort);
        Thread.sleep(2000);



        By clickAndHoldItem = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[3]/android.widget.TextView\n");
        //casting the driver to AppiumDriver so i can use touchActions with it
        AppiumDriver appiumDriver = (AppiumDriver) driver.getDriver();
        int x = 1000; // X coordinate of the target location
        int y = 300; // Y coordinate of the target location


        // using TouchActions with AppiumDriver to Hold the item that i want to drag and then move it to specific coordinates and then release it
        TouchAction touchAction = new TouchAction((PerformsTouchActions) appiumDriver);
        touchAction.longPress(ElementOption.element(appiumDriver.findElement(clickAndHoldItem)))
                .moveTo(PointOption.point(x, y))
                .release()
                .perform();


        


Thread.sleep(10000);

    }
}
