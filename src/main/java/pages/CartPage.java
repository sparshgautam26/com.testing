package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "inventory_item_name")
    WebElement productName;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public boolean isProductDisplayed() {
        return productName.isDisplayed();
    }

    public String getProductName() {
        return productName.getText();
    }

    public void clickCheckout() {
        checkoutBtn.click();
    }
}

