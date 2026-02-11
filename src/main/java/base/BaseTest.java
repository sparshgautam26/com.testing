package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void initialization() {

        System.out.println("=== Browser Initializing ===");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        System.out.println("=== Browser Launched ===");
    }

    @AfterMethod
    public void quitBrowser() {

        if (driver != null) {
            driver.quit();
            System.out.println("=== Browser Closed ===");
        }
    }
}
