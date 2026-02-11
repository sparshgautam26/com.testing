package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static void capture(WebDriver driver, String testName) {

	    if (driver == null) {
	        System.out.println("Driver is null. Screenshot skipped.");
	        return;
	    }

	    try {
	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(src, new File("screenshots/" + testName + ".png"));
	    } catch (Exception e) {
	        System.out.println("Screenshot failed: " + e.getMessage());
	    }
	}}
