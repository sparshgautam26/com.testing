package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test(groups = {"regression", "positive"})
    public void verifyProductInCartTest() {

        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addProductToCart();
        inventory.clickCart();

        CartPage cart = new CartPage(getDriver());

        Assert.assertTrue(cart.isProductDisplayed(),
                "Product not displayed in cart");

        Assert.assertEquals(cart.getProductName(),
                "Sauce Labs Backpack",
                "Wrong product in cart");
    }
    @Test(groups = {"negative"})
    public void checkoutWithoutProductTest() {

        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.clickCart();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("cart"),
                "Cart page not loaded properly");
    }

}
