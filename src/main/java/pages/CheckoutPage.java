package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public void enterDetails(String f, String l, String p) {
        log("Entering checkout details");
        type(firstName, f, "First Name");
        type(lastName, l, "Last Name");
        type(postalCode, p, "Postal Code");
        click(continueBtn, "Continue Button");
    }

    public void finishOrder() {
        log("Finishing Order");
        click(finishBtn, "Finish Button");
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
}
