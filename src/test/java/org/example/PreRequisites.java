package org.example;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;

public class PreRequisites {
    static SHAFT.GUI.WebDriver driver;
    static AppiumDriver appiumDriver;

    public void pre() {
        SHAFT.Properties.mobile.set().automationName(AutomationName.ANDROID_UIAUTOMATOR2);
        SHAFT.Properties.platform.set().targetPlatform("Android");
        SHAFT.Properties.platform.set().executionAddress("localhost:4723");
        SHAFT.Properties.browserStack.set().deviceName("DeviceOne");
        SHAFT.Properties.mobile.set().app("src/test/resources/testDataFiles/apps/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");


        driver = new SHAFT.GUI.WebDriver();
        appiumDriver = (AppiumDriver) driver.getDriver();
    }
}
