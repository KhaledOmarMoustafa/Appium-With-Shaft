package org.example;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

public class EnterDetails {


    public void details() throws InterruptedException {

        AddItemsToTheCart.endY = AddItemsToTheCart.startY - 2000;

        AddItemsToTheCart.touchAction.longPress(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.startY))
                .moveTo(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.endY))
                .release()
                .perform();

        Thread.sleep(2000);
        By clickOnCheckOut = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(clickOnCheckOut);


        String checkOutInformation = PreRequisites.appiumDriver.findElement(By.xpath
                ("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n")).getText();

        String ActualcheckOutInformation = "CHECKOUT: INFORMATION";

        PreRequisites.driver.element().assertThat(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")).equals(ActualcheckOutInformation);

        By firstName = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]\n");
        PreRequisites.driver.element().type(firstName, "khaled");

        By lastName = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]\n");
        PreRequisites.driver.element().type(lastName, "omar");

        By postalCode = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]\n");
        PreRequisites.driver.element().type(postalCode, "122335");

        By clickContinue = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(clickContinue);
    }
}
