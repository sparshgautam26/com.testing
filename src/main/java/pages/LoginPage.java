package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("h3[data-test='error']");
    By inventoryTitle = By.className("title");

    public void login(String user, String pass) {
        log("Starting Login");
        type(username, user, "Username");
        type(password, pass, "Password");
        click(loginBtn, "Login Button");
    }

    public boolean isLoginSuccess() {
        log("Checking login success");
        return driver.findElement(inventoryTitle).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        log("Checking error message");
        return driver.findElement(errorMsg).isDisplayed();
    }
}
