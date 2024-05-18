import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    //Get an element
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    //Get all the elements and add to a list for accessibility
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    // Click an object
    public void clickAnObject(By locator){
        find(locator).click();
    }
    // Find an element and enter a string for input
    public void write(By locator, String text){
        find(locator).sendKeys(text);
    }
    // Check the page if the element is displayed
    public boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
}
