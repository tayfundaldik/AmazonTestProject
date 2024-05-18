import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected ProductsPage productsPage;
    protected ProductDetailPage productDetailPage;
    protected CardPage cardPage;

    // Set chrome driver an target url before all tests started
    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
    }
    // Create instances before each test begins
    @BeforeEach
    public void initPages() {
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        cardPage = new CardPage(driver);
    }
    // Close window when the all the tests ended
    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

