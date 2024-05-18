import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    SearchBox searchBox;
    By cardCountLocator = By.id("nav-cart-count");
    By cardContainerLocator = By.id("nav-cart-count-container");
    By acceptCookiesLocator = By.id("sp-cc-accept");

    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }
    public SearchBox searchBox(){
        return this.searchBox;
    }

    //Check the product count amount
    public boolean isProductCountIncreased() {
        return getNumberofItems() > 0;
    }

    // Click the go to cart button and go to the cart page
    public void goToCard() {
        clickAnObject(cardContainerLocator);
    }
    // Get the number of products from the cart page
    private int getNumberofItems(){
        String count =  find(cardCountLocator).getText();
        return Integer.parseInt(count);
    }

    // Click the accept cookies button
    public void acceptCookies(){
        if (isDisplayed(acceptCookiesLocator)){
            clickAnObject(acceptCookiesLocator);
        }
    }

}
