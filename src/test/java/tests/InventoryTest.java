package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test(groups = {"regression", "positive"})
    public void addProductToCartTest() {

        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(getDriver());
        inventory.addProductToCart();

        Assert.assertEquals(inventory.getCartCount(), "1",
                "Cart count is incorrect");
    }

    @Test(groups = {"negative"})
    public void removeProductWithoutAddingTest() {

        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(getDriver());

        // Do NOT add product
        Assert.assertTrue(getDriver().getPageSource()
                .contains("Products"),
                "Inventory page not loaded correctly");
    }
}
