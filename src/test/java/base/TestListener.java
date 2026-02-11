package base;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        if (BaseTest.getDriver() != null) {

            ScreenshotUtil.capture(
                    BaseTest.getDriver(),
                    result.getName()
            );

            BaseTest.getDriver().quit();
            BaseTest.removeDriver();   // IMPORTANT
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        if (BaseTest.getDriver() != null) {
            BaseTest.getDriver().quit();
            BaseTest.removeDriver();   // IMPORTANT
        }
    }
}
