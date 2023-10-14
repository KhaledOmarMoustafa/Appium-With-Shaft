package org.example;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class AddItemsToTheCart {


    static TouchAction touchAction;

    static int x;
    static int y;
    static int startX;
    static int startY;
    static int endY;

    public void addItems() throws InterruptedException {
        By addFirstItem = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[2]/android.widget.TextView\n");
        PreRequisites.driver.element().click(addFirstItem);

        By sort = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView\n");
        PreRequisites.driver.element().click(sort);
        Thread.sleep(2000);


        By clickAndHoldItem = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[3]/android.widget.TextView\n");
        //casting the driver to AppiumDriver so i can use touchActions with it

        x = 1000; // X coordinate of the target location
        y = 300; // Y coordinate of the target location


        // using TouchActions with AppiumDriver to Hold the item that i want to drag and then move it to specific coordinates and then release it
        touchAction = new TouchAction((PerformsTouchActions) PreRequisites.appiumDriver);
        touchAction.longPress(ElementOption.element(PreRequisites.appiumDriver.findElement(clickAndHoldItem)))
                .moveTo(PointOption.point(x, y))
                .release()
                .perform();

        By sortBy = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView\n");
        PreRequisites.driver.element().click(sortBy);


        Thread.sleep(1000);

        By chooseOption = By.xpath("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView\n");
        PreRequisites.driver.element().click(chooseOption);

// scroll down the screen using touchAction
        Dimension screenSize = PreRequisites.appiumDriver.manage().window().getSize();
        startX = screenSize.getWidth() / 2;
        startY = screenSize.getHeight() / 2;
        System.out.println(startX);
        System.out.println(startY);

        endY = startY - 700;

        touchAction.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();

        By addThirdItem = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[3]/android.widget.TextView\n");
        PreRequisites.driver.element().click(addThirdItem);

        // assert that the cart count is equal to the actual result
        String actualCartCount = "3";


        PreRequisites.driver.element().assertThat(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.TextView\n"))
                .equals(actualCartCount);


        By clickOnCart = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView\n");
        PreRequisites.driver.element().click(clickOnCart);

        Thread.sleep(1000);
    }
}
