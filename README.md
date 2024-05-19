![Amazon_logo](https://github.com/tayfundaldik/AmazonTestProject/assets/79011413/ed891787-3fe2-4315-b5de-8c0ac2d3ef21)

# Amazon Test Project

## Introduction
This project tests a scenario where a user checks the products in their cart on the Amazon website.<br/><br/>

Scenario Steps:<br/>
1- User goes to "https://www.amazon.com.tr/".<br/>
2- User types a product name into the search box and clicks the search button.<br/>
3- User clicks on a product.<br/>
4- User adds product to the cart.<br/>
5- User clicks "Go to Cart" button and goes to cart page.<br/>
<br/>
### BasePage Class
BasePage class is the basic class of all classes. That class provides basic actions, such as finding an element and clicking an element, which can be used by other classes in the program.
 ```java
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
 ```
### CardPage Class
CardPage class checks the cart if the product is added.
 ```java
    // Check the cart if the product is added
    public boolean isProductOnCard() {
      return getCardProducts().size()>0;
    }
    // Get all the products from the cart and add them into a list
    private List<WebElement> getCardProducts(){
        return findAll(itemLocator);
    } 
```
### HomePage Class
HomePage class has operations that user can do at the Amazon home page such as going to cart page, accept cookies etc.
 ```java
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
```
