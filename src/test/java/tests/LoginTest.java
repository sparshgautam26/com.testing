package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import base.BaseTest;
import pages.LoginPage;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

    LoginPage login;

    @BeforeMethod
    public void pageSetup() {
        login = new LoginPage(getDriver());
    }

    @Test(priority = 1 ,groups = "positive")
    public void validLoginTest() throws InterruptedException {
   
        System.out.println("=== Valid Login Test Started ===");

        login.login("standard_user", "secret_sauce");

        Thread.sleep(3000);

        String currentUrl = getDriver().getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Assert.assertTrue(currentUrl.contains("inventory"),
                "Login failed - Inventory page not loaded");
    }


    @Test(priority = 2, groups = "negative")
    public void invalidLoginTest() {

        login.login("invalid_user", "wrong_pass");

        String errorMsg = login.getErrorMessage();
        System.out.println("Error Message: " + errorMsg);

        Assert.assertTrue(errorMsg.contains("Username and password"),
                "Expected error message not displayed");
    }
}
