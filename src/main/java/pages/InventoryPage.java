package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpack;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    public void addProductToCart() {
        addBackpack.click();
    }

    public void removeProductFromCart() {
        removeBackpack.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }

    public void clickCart() {
        cartIcon.click();
    }
}
