import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTest extends BaseTest{
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckOutPage checkOutPage;

    @Test
    public void validRegisterTest()  {
        registerPage= homePage.navToRegister();
        registerPage.setFirstname("ahmed");
        registerPage.setLastname("elbaily");
        registerPage.selectBirthDay("20");
        registerPage.selectBirthMonth("January");
        registerPage.selectBirthYear("1998");
        registerPage.setEmail("testp3@gmail.com");
        registerPage.setPassword("Test123");
        registerPage.setConfirmPassword("Test123");
        registerPage.clickRegister();

        Assert.assertTrue(registerPage.getConfirmationMassage().contains("Your registration completed"));
    }
    @Test(priority = 1)
    public void validLoginTest()  {
        loginPage= homePage.navToLogin();
        loginPage.setEmail("testp@gmail.com");
        loginPage.setPassword("Test123");
        loginPage.login();
        Assert.assertTrue(homePage.getWelcome().contains("Welcome to our store"));
    }
    @Test(priority = 2)
    public void searchResultTest() {
        searchPage=homePage.searchItem("Apple");
        Assert.assertTrue(searchPage.searchForItemName("Apple"));
    }
    @Test (priority = 3)
    public void AddItemToCartTest(){
        productPage = searchPage.navToProduct();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/apple-macbook-pro-13-inch");
        productPage.addToCart();
    }
    @Test(priority = 4)
    public void testItemsInCart() {
        cartPage = homePage.navToCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/cart");
        Assert.assertTrue(cartPage.getProductName().contains("Apple MacBook Pro 13-inch"), "Wrong item in cart");
    }
    @Test(priority = 5)
    public void checkOutTest () {
        cartPage.acceptTerms();
        checkOutPage =cartPage.navToCheckOut();
        Assert.assertEquals(checkOutPage.getPageTitle(),"Checkout");
        checkOutPage.setCountryField("Egypt");
        checkOutPage.setCityField("Cairo");
        checkOutPage.setAddressOneField("Cairo street");
        checkOutPage.setZipCodeField("1234");
        checkOutPage.setPhoneNumberField("01234567890");
        checkOutPage.continueBillingAddressForm();
        checkOutPage.continueShippingMethodForm();
        checkOutPage.continuePaymentMethod();
        checkOutPage.continuePaymentInformation();
        checkOutPage.confirmOrder();
        Assert.assertTrue(checkOutPage.getConfirmationMsg().contains("Your order has been successfully processed!"),"CheckOut process Failed");
    }
}
