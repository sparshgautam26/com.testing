package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    // ThreadLocal for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver.set(new ChromeDriver(options));

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        getDriver().get("https://www.saucedemo.com/");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            removeDriver();
        }
    }


    // 🔥 Always use this method in tests
    public static WebDriver getDriver() {
        return driver.get();
    }

    // 🔥 Required for ThreadLocal cleanup
    public static void removeDriver() {
        driver.remove();
    }
}
