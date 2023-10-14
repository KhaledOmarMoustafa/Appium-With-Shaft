package org.example;

import org.testng.annotations.Test;

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

    @Test(priority = 2)
    public void EnterLoginDetails() {
        l.login();
    }

    @Test(priority = 3)
    public void addItemsToCart() throws InterruptedException {
        add.addItems();
    }

    @Test(priority = 4)
    public void EnterShippingDetails() throws InterruptedException {
        enter.details();
    }

    @Test(priority = 5)
    public void checkOutItems() {
        co.checkOut();
    }

    @Test(priority = 6)
    public void logOut() throws InterruptedException {
        lo.logOut();
    }

}
