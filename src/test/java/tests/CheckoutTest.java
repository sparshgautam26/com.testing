package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.*;

public class CheckoutTest extends BaseTest {

	@Test
	public void checkoutWithValidDetails() {

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

	    Assert.assertTrue(
	            checkout.getSuccessMessage().toLowerCase()
	                    .contains("thank you"),
	            "Order not completed"
	    );
	}}
