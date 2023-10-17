package org.example;

import org.openqa.selenium.By;

public class Login {

    public void login() throws InterruptedException {
        By invalidUser = By.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]\n");
        PreRequisites.driver.element().type(invalidUser, "locked_out_user");

        By invalidUserpassWord = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]\n");
        PreRequisites.driver.element().type(invalidUserpassWord, "secret_sauce");

        By loginwithInvalidUser = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(loginwithInvalidUser);

       /* String errorMessage = "Sorry, this user has been locked out.";
        By errorLocator = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView\n");
        String errorMessageLocator = PreRequisites.driver.element().getText(errorLocator);*/


        Thread.sleep(2000);

        if (PreRequisites.driver.element().isElementDisplayed(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView\n"))) {
            PreRequisites.appiumDriver.findElement(invalidUser).clear();
            String userField = PreRequisites.appiumDriver.findElement(invalidUser).getText();
            System.out.println(userField);

            PreRequisites.appiumDriver.findElement(invalidUserpassWord).clear();

            Thread.sleep(1000);


            PreRequisites.driver.element().type(invalidUser, "standard_user");


            //By passWord = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]\n");
            PreRequisites.driver.element().type(invalidUserpassWord, "secret_sauce");

            By login = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView\n");
            PreRequisites.driver.element().click(login);
        }
    }
}
