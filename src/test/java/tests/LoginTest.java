package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        login.login("standard_user", "secret_sauce");

        Assert.assertTrue(login.isLoginSuccess());
    }

    @Test
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        login.login("wrong", "wrong");

        Assert.assertTrue(login.isErrorDisplayed());
    }
}
