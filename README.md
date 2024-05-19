![Amazon_logo](https://github.com/tayfundaldik/AmazonTestProject/assets/79011413/ed891787-3fe2-4315-b5de-8c0ac2d3ef21)

# AmazonTestProject

## Introduction
This project tests a scenario where a user checks the products in their cart on the Amazon website.

Scenario Steps:
1- User goes to "https://www.amazon.com.tr/".
2- User types a product name into the search box and clicks the search button.
3- User clicks on a product.
4- User adds product to the cart.
5- User clicks "Go to Cart" button and goes to cart page.

### BasePage Class
BasePage class is the basic class of all classes. That class provides basic actions, such as finding an element and clicking an element, which can be used by other classes in the program.

    WebDriver driver;
    
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


