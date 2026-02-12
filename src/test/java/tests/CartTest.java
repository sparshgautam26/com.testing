package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class CartTest extends BaseTest {

	@Test
	public void verifyProductInCartTest() {

	    LoginPage login = new LoginPage(getDriver());
	    login.login("standard_user", "secret_sauce");

	    InventoryPage inventory = new InventoryPage(getDriver());
	    inventory.addProductToCart();
	    inventory.goToCart();

	    CartPage cart = new CartPage(getDriver());

	    Assert.assertTrue(cart.isProductDisplayed());
	    Assert.assertEquals(cart.getProductName(), "Sauce Labs Backpack");
	}
}