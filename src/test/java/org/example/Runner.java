package org.example;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Runner {
    private final PreRequisites pre;
    private final Login l;
    private final AddItemsToTheCart add;
    private final EnterDetails enter;
    private final CheckOut co;
    private final LogOut lo;

    public Runner() {

        pre = new PreRequisites();
        l = new Login();
        add = new AddItemsToTheCart();
        enter = new EnterDetails();
        co = new CheckOut();
        lo = new LogOut();
    }

    @Test(priority = 1)
    public void PreRequisites() {
        pre.pre();
    }

    @Test(priority = 2, dataProvider = "readTheSheet")
    public void EnterLoginDetails(String userName, String passWord) throws InterruptedException {
        l.login(userName, passWord);
    }

    @Test(priority = 3)
    public void addItemsToCart() throws InterruptedException {
        add.addItems();
    }

    @Test(priority = 4, dataProvider = "readTheSecondSheet")
    public void EnterShippingDetails(String firstName, String lastName, String postalCode) throws InterruptedException {
        enter.details(firstName, lastName, postalCode);
    }

    @Test(priority = 5)
    public void checkOutItems() {
        co.checkOut();
    }

    @Test(priority = 6)
    public void logOut() throws InterruptedException {
        lo.logOut();
    }

    @DataProvider(name = "readTheSheet")
    public String[][] readTheSheet() throws IOException, InvalidFormatException {
        Read_Data rd = new Read_Data();
        return rd.read_Data();

    }

    @DataProvider(name = "readTheSecondSheet")
    public String[][] readTheSecondSheet() throws IOException, InvalidFormatException {
        Read_Data rd = new Read_Data();
        return rd.read_DataTwo();

    }


}
