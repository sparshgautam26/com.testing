package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

    	System.out.println("===== Browser Launching =====");
        ChromeOptions options = new ChromeOptions();

        // IMPORTANT — Fresh clean session
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManagerOnboarding");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void tearDown() {
    	System.out.println("===== Browser Closed =====");
        if (driver != null) {
            driver.quit();
        }
    }



    
        }
    

