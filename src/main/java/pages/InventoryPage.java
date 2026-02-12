package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
 // LOCATORS
    private By menuBtn = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    // METHOD
   
    


    public void addProductToCart() {
        log("Adding product to cart");
        click(addToCartBtn, "Add To Cart");
    }

    public void goToCart() {
        log("Navigating to cart page");
        click(cartIcon, "Cart Icon");
    
    }
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        
        
        public void logoutFromApp() {
            log("Logging out from application");

            click(menuBtn, "Menu Button");
            waitForSeconds(1);
            click(logoutLink, "Logout Link");
            waitForSeconds(1);
        

    }

    }
