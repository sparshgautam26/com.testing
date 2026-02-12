package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text, String fieldName) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
        log("Entered text in: " + fieldName);
    }

    protected void click(By locator, String elementName) {
        driver.findElement(locator).click();
        log("Clicked on: " + elementName);
    }

    protected String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void log(String message) {
        System.out.println(message);
    }
}
