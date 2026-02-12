package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginSecurityTest extends BaseTest {

    @Test
    public void boundaryAbuse_LongInputTest() {

        LoginPage login =
                new LoginPage(getDriver());

        String longInput =
                "a".repeat(500);

        login.login(longInput, longInput);

        Assert.assertTrue(
                login.getErrorText().length() > 0,
                "App crashed or no error shown for long input.");
    }

    @Test
    public void boundaryAbuse_SQLInjectionTest() {

        LoginPage login =
                new LoginPage(getDriver());

        login.login("' OR 1=1 --", "' OR 1=1 --");

        Assert.assertTrue(
                login.getErrorText().length() > 0,
                "SQL Injection possible.");
    }

    @Test
    public void boundaryAbuse_ScriptInjectionTest() {

        LoginPage login =
                new LoginPage(getDriver());

        login.login("<script>alert(1)</script>", "test");

        Assert.assertTrue(
                login.getErrorText().length() > 0,
                "XSS vulnerability possible.");
    }
}
