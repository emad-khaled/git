import Pages.CartPage;
import Pages.ProductPage;
import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AddToCartTest extends BaseTest{
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage ;

    @Test
    public void searchForItem(){
        searchPage=homePage.searchItem("Apple");
    }
    @Test (priority = 1)
    public void AddItemToCartTest(){
        productPage =  searchPage.navToProduct();
        Assert.assertEquals(productPage.getProductName(),"Apple MacBook Pro 13-inch","Product name is wrong");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        productPage.setProductQuantity("5");
        productPage.addToCart();
        HashMap<String,String> lol = new HashMap<>();
lol.put("key","value");
    }
    @Test(priority = 2)
    public void testItemsInCart() {
        cartPage = homePage.navToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");
        Assert.assertTrue(cartPage.getProductName().contains("Apple MacBook Pro 13-inch"), "Wrong item in cart");
        Assert.assertEquals(cartPage.getUnitPrice(), "$1,800.00", "Unit price is wrong");
        Assert.assertEquals(cartPage.getQuantity(), "5", "Quantity of the product is wrong");
        Assert.assertEquals(cartPage.getProductTotal(), "$9,000.00");
    }
    @Test(priority = 3)
    public void RemoveFromCart () {
        cartPage.removeItem();
        Assert.assertTrue(cartPage.getEmptyCartMsg().contains("Your Shopping Cart is empty!"),"Cart is not empty");
    }
}
