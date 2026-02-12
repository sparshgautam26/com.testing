package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class RaceConditionHardTest extends BaseTest {

    @Test(invocationCount = 10, threadPoolSize = 10)
    public void heavyParallelLoginTest() {

        LoginPage login =
                new LoginPage(getDriver());

        login.login("standard_user",
                "secret_sauce");

        Assert.assertTrue(
                login.isLoginSuccess(),
                "Parallel login failed.");
    }
}
