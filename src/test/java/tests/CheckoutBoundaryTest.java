package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class CheckoutBoundaryTest
        extends BaseTest {

    @Test
    public void blankFieldsTest(){

        LoginPage login =
                new LoginPage(getDriver());
        login.login("standard_user",
                "secret_sauce");

        InventoryPage inv =
                new InventoryPage(getDriver());
        inv.addProductToCart();
        inv.goToCart();

        CartPage cart =
                new CartPage(getDriver());
        cart.clickCheckout();

        CheckoutPage check =
                new CheckoutPage(getDriver());

        check.enterDetails("", "", "");

        Assert.assertTrue(
                getDriver().getPageSource()
                        .contains("Error"));
    }
}
