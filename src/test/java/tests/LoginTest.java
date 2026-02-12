package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.RetryAnalyzer;

public class LoginTest extends BaseTest {

    // =========================================
    // DATA PROVIDER
    // =========================================
    @DataProvider(name = "loginData", parallel = true)
    public Object[][] loginData() {

        return new Object[][]{

                // VALID
                {"standard_user", "secret_sauce", true},

                // NEGATIVE
                {"wrong", "wrong", false},
                {"", "secret_sauce", false},
                {"standard_user", "", false},
                {"", "", false},
                {"locked_out_user", "secret_sauce", false}
        };
    }

    // =========================================
    // LOGIN TEST
    // =========================================
    @Test(dataProvider = "loginData",
          retryAnalyzer = RetryAnalyzer.class)
    public void loginTest(String username,
                          String password,
                          boolean expectedSuccess) {

        LoginPage login =
                new LoginPage(getDriver());

        login.login(username, password);

        // -------- VALID CASE --------
        if (expectedSuccess) {

            Assert.assertTrue(
                    login.isLoginSuccess(),
                    "Login should succeed but failed.");
        }

        // -------- NEGATIVE CASE --------
        else {

            String actualError =
                    login.getErrorText();

            Assert.assertTrue(
                    actualError.contains(
                            "Username and password do not match"),
                    "Expected error message not shown. Actual: "
                            + actualError);
        }
    }
}
