import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    By addToCardBtnLocator = By.id("add-to-cart-button");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }
    // Check the page if it is selected product's page
    public boolean isProductDetailPage() {
        return isDisplayed(addToCardBtnLocator);
    }
    // Add product to cart
    public void addToCard() {
        clickAnObject(addToCardBtnLocator);
    }
}
