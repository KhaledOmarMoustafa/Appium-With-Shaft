package org.example;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckOut {

    public void checkOut() {

        String firstItemPrice = PreRequisites.appiumDriver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Price\"])[1]/android.widget.TextView\n")).getText();
        firstItemPrice = firstItemPrice.replaceAll("[^\\d.]", "");
        double first = Double.parseDouble(firstItemPrice);
        System.out.println(first);

        AddItemsToTheCart.endY = AddItemsToTheCart.startY - 1000;

        AddItemsToTheCart.touchAction.longPress(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.startY))
                .moveTo(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.endY))
                .release()
                .perform();


        String secondItemPrice = PreRequisites.appiumDriver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Price\"])[2]/android.widget.TextView\n")).getText();
        secondItemPrice = secondItemPrice.replaceAll("[^\\d.]", "");
        double second = Double.parseDouble(secondItemPrice);
        System.out.println(second);

        String thirdItemPrice = PreRequisites.appiumDriver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Price\"])[3]/android.widget.TextView\n")).getText();
        thirdItemPrice = thirdItemPrice.replaceAll("[^\\d.]", "");
        double third = Double.parseDouble(thirdItemPrice);
        System.out.println(third);


        double totalOfThreeItems = first + second + third;

        System.out.println(totalOfThreeItems);

        AddItemsToTheCart.endY = AddItemsToTheCart.startY - 1000;

        AddItemsToTheCart.touchAction.longPress(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.startY))
                .moveTo(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.endY))
                .release()
                .perform();


        String itemTotal = PreRequisites.appiumDriver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[5]\n")).getText();
        itemTotal = itemTotal.replaceAll("[^\\d.]", "");
        double totalItem = Double.parseDouble(itemTotal);
        System.out.println(totalItem);

        Assert.assertEquals(totalOfThreeItems, totalItem);


        String tax = PreRequisites.appiumDriver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[6]\n")).getText();
        tax = tax.replaceAll("[^\\d.]", "");
        double taxes = Double.parseDouble(tax);
        double taxWithTwoDecimals = Double.parseDouble(String.format("%,.2f", taxes));

        double taxDeductedFromTotal = totalOfThreeItems * 0.08;
        double taxDeducted = Double.parseDouble(String.format("%,.2f", taxDeductedFromTotal));

        Assert.assertEquals(taxWithTwoDecimals, taxDeducted);


        String total = PreRequisites.appiumDriver.findElement(By.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[7]\n")).getText();
        total = total.replaceAll("[^\\d.]", "");
        double totalWithTax = Double.parseDouble(total);

        double totalWithTaxes = taxWithTwoDecimals + totalItem;


        Assert.assertEquals(totalWithTax, totalWithTaxes);

        AddItemsToTheCart.endY = AddItemsToTheCart.startY - 500;

        AddItemsToTheCart.touchAction.longPress(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.startY))
                .moveTo(PointOption.point(AddItemsToTheCart.startX, AddItemsToTheCart.endY))
                .release()
                .perform();


        By finish = By.xpath("//android.view.ViewGroup[@content-desc=\"test-FINISH\"]/android.widget.TextView\n");
        PreRequisites.driver.element().click(finish);

    }
}
