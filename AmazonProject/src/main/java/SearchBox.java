import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{

    By SBLocator = By.id("twotabsearchtextbox");
    By SBButtonLocator = By.id("nav-search-submit-button");
    public SearchBox(WebDriver driver) {
        super(driver);
    }

    // Enter product name to search box and click the search button
    public void search(String text){
        write(SBLocator, text);
        clickAnObject(SBButtonLocator);
    }
}
