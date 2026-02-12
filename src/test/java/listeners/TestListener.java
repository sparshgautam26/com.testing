package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object obj = result.getInstance();
        WebDriver driver =
                ((BaseTest)obj).getDriver();

        ScreenshotUtil.capture(driver,
                result.getName());
    }
}
