package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class RateLimitTest extends BaseTest {

    @Test
    public void multipleInvalidLoginTest() {

        LoginPage login =
                new LoginPage(getDriver());

        for(int i = 0; i < 5; i++) {

            login.login("wrong", "wrong");
        }

        String error =
                login.getErrorText();

        Assert.assertTrue(
                error.length() > 0,
                "No rate limiting or protection detected.");
    }
}
