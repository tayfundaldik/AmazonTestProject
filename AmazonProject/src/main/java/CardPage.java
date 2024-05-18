import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CardPage extends BasePage{

    By itemLocator = By.id("sc-buy-box-ptc-button-announce");

    public CardPage(WebDriver driver){
        super(driver);
    }
    // Check the cart if the product is added
    public boolean isProductOnCard() {
      return getCardProducts().size()>0;
    }
    // Get all the products from the cart and add them into a list
    private List<WebElement> getCardProducts(){
        return findAll(itemLocator);
    }
}
