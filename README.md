!https://m.media-amazon.com/images/G/41/gc/designs/livepreview/amazon_dkblue_noto_email_v2016_tr-main._CB436417590_.png

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
### ProductDetailPage Class
ProductDetailPage class controls and checks the product details page that is displayed when a user clicks on a product in the search results page.
```java
    // Check the page if it is selected product's page
    public boolean isProductDetailPage() {
        return isDisplayed(addToCardBtnLocator);
    }
    // Add product to cart
    public void addToCard() {
        clickAnObject(addToCardBtnLocator);
    }
```
### ProductsPage Class
ProductPage class has controls and checks the search results page that is displayed when user searchs for a product.
```java
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
```
### Test_Add_to_Card Test Class
Test_Add_to_Card test class tests the scenario where a user wants to add a product to the cart and checks if the product is successfully added.
```java
    // Accept cookies, enter a product name to search box and check the page if it is the searched product page
    @Test
    @Order(1)
    public void search_product(){
        homePage.acceptCookies();
        homePage.searchBox().search("Laptop");
        Assertions.assertTrue(productsPage.isProductPage(), "Not on Products Page");
    }
    // Select second product on the page and check the page if it is the selected product page
    @Test
    @Order(2)
    public void select_product(){
        productsPage.selectProduct(1);
        Assertions.assertTrue(productDetailPage.isProductDetailPage(),"Not on Product Details Page");
    }
    // Add product to card and check the cart count amount
    @Test
    @Order(3)
    public void add_product(){
        productDetailPage.addToCard();
        Assertions.assertTrue(homePage.isProductCountIncreased(), "Product count is not increased");
    }
    // Go to cart and check the cart if the product is added
    @Test
    @Order(4)
    public void go_to_card(){
        homePage.goToCard();
        Assertions.assertTrue(cardPage.isProductOnCard(), "Product is not added to the card");
    }
```
