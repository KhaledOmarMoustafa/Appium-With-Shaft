package org.example;

import org.openqa.selenium.By;

public class LogOut {

    public void logOut() throws InterruptedException {
        String checkOutPage = "CHECKOUT: COMPLETE!";

        PreRequisites.driver.element().assertThat(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView\n")).equals(checkOutPage);

        By backHomeBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(backHomeBtn);

        Thread.sleep(1000);

        By burgerBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView\n");
        PreRequisites.driver.element().click(burgerBtn);

        Thread.sleep(1000);

        By logOutBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]\n");
        PreRequisites.driver.element().click(logOutBtn);

        Thread.sleep(1000);

        PreRequisites.driver.element().assertThat(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView\n")).exists();

        Thread.sleep(4000);

    }
}
