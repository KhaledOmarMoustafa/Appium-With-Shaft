package org.example;

import org.openqa.selenium.By;

public class Login {

    public void login() {


        By userName = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]\n");
        PreRequisites.driver.element().type(userName, "standard_user");

        By passWord = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]\n");
        PreRequisites.driver.element().type(passWord, "secret_sauce");

        By login = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(login);
    }
}
