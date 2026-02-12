package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class E2ETest extends BaseTest {

    @Test
    public void completeOrderFlow() {

        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addProductToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(getDriver());
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(getDriver());
        checkout.enterDetails("Sparsh", "Gautam", "251001");
        checkout.finishOrder();

        String successMsg = checkout.getSuccessMessage();
        Assert.assertTrue(successMsg.contains("Thank you"),
                "Order not completed");

        System.out.println("===== E2E TEST COMPLETED SUCCESSFULLY =====");
    }
}
