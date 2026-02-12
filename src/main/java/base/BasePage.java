package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator, String elementName) {
        waitForVisibility(locator);
        driver.findElement(locator).click();
        log("Clicked on: " + elementName);
    }

    public void type(By locator, String text, String elementName) {
        waitForVisibility(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        log("Entered text in: " + elementName);
    }

    public void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getText(By locator) {
        waitForVisibility(locator);
        return driver.findElement(locator).getText();
    }

    public void log(String message) {
        System.out.println("👉 " + message);
    }
}
