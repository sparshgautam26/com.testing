package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class BackButtonSecurityTest extends BaseTest {

    @Test
    public void logoutBackButtonAccessTest() {

        LoginPage login =
                new LoginPage(getDriver());

        login.login("standard_user",
                "secret_sauce");

        getDriver().get(
                "https://www.saucedemo.com/inventory.html");

        getDriver().navigate().back();

        boolean stillLoggedIn =
                getDriver().getCurrentUrl()
                        .contains("inventory");

        Assert.assertFalse(
                stillLoggedIn,
                "User can access inventory after logout via back button.");
    }
}
