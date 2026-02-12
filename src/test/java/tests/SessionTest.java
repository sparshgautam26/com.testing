package tests;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class SessionTest extends BaseTest {

    @Test
    public void sessionCookieAfterLoginTest() {

        LoginPage login =
                new LoginPage(getDriver());

        login.login("standard_user",
                "secret_sauce");

        Cookie session =
                getDriver().manage()
                        .getCookieNamed("session-username");

        Assert.assertNotNull(
                session,
                "Session cookie not set after login.");
    }
}
