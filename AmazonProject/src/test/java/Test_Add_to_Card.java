import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Add_to_Card extends BaseTest{

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

}
