package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import base.BasePage;

public class LoginPage extends BasePage {

    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("h3[data-test='error']");
    By inventoryTitle = By.className("title");

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccess() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryTitle));
            return driver.findElement(inventoryTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorText() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
