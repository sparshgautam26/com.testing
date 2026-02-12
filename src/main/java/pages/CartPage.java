package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By productName = By.className("inventory_item_name");
    By checkoutBtn = By.id("checkout");

    public boolean isProductDisplayed() {
        log("Checking product in cart");
        return driver.findElement(productName).isDisplayed();
    }

    public String getProductName() {
        return getText(productName);
    }

    public void clickCheckout() {
        click(checkoutBtn, "Checkout Button");
    }
}
