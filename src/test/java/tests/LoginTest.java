package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {

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

    @Test(dataProvider = "loginData")
    public void loginTest(String username,
                          String password,
                          boolean expectedSuccess) {

        LoginPage login = new LoginPage(getDriver());

        // 🔥 Force fresh state every iteration
        login.openLoginPage();

        login.login(username, password);

        if (expectedSuccess) {

            Assert.assertTrue(
                    login.isLoginSuccess(),
                    "Login should succeed but failed"
            );

        } else {

            String error = login.getErrorText();

            Assert.assertTrue(
                    error.toLowerCase().contains("epic sadface"),
                    "Expected error not shown. Actual: " + error
            );
        }
    }
}
