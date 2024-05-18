import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage extends BasePage {

    By shippingOptionLocator = By.id("p_n_free_shipping_eligible-title");
    By productNameLocator = new By.ByCssSelector("span.a-size-base-plus");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    // Check the page if it is searched product's page
    public boolean isProductPage(){
        return isDisplayed(shippingOptionLocator);
    }
    // Select a product
    public void selectProduct(int i) {
        products().get(i).click();
    }
    // Get all the elements from the page and add them into a list
    private List<WebElement> products(){
        return findAll(productNameLocator);
    }
}
