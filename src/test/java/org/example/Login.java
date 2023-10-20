package org.example;

import org.openqa.selenium.By;

public class Login {

    public void login(String userName, String pword) throws InterruptedException {
        By invalidUser = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]\n");
        PreRequisites.driver.element().type(invalidUser, userName);

        By invalidUserpassWord = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]\n");
        PreRequisites.driver.element().type(invalidUserpassWord, pword);

        By loginwithInvalidUser = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(loginwithInvalidUser);


        Thread.sleep(2000);


    }
}
