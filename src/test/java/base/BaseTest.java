package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();  // IMPORTANT

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        WebDriver localDriver = new ChromeDriver(options);

        localDriver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        localDriver.get("https://www.saucedemo.com/");

        driver.set(localDriver);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
