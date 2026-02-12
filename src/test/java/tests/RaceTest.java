package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class RaceTest extends BaseTest {

    @Test(invocationCount = 3,
          threadPoolSize = 3)
    public void sameUserLoginRace(){

        LoginPage login =
                new LoginPage(getDriver());

        login.login("standard_user",
                "secret_sauce");

        Assert.assertTrue(
                login.isLoginSuccess());
    }
}
