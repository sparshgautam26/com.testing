package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class ErrorMessageSecurityTest extends BaseTest {

    @Test
    public void errorMessageShouldBeGeneric() {

        LoginPage login =
                new LoginPage(getDriver());

        String testUser = "wrongUser";
        String testPass = "wrongPass";

        login.login(testUser, testPass);

        String error =
                login.getErrorText();

        // ❌ Error message should NOT reveal username
        Assert.assertFalse(
                error.contains(testUser),
                "Security issue: Error message reveals username!");

        // ❌ Error message should NOT reveal password
        Assert.assertFalse(
                error.contains(testPass),
                "Security issue: Error message reveals password!");

        // ✅ Error should be generic
        Assert.assertTrue(
                error.toLowerCase()
                        .contains("do not match"),
                "Unexpected error message format: " + error);
    }
}
