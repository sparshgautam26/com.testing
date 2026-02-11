package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

	    if (BaseTest.driver != null) {
	        ScreenshotUtil.capture(BaseTest.driver, result.getName());
	        BaseTest.driver.quit();
	        BaseTest.driver = null;
	    }
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	    if (BaseTest.driver != null) {
	        BaseTest.driver.quit();
	        BaseTest.driver = null;
	    }
	}
}