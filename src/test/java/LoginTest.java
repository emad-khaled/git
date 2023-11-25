import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage loginPage;
    @Test
    public void validLoginTest()  {
        loginPage = homePage.navToLogin();
        loginPage.setEmail("testp@gmail.com");
        loginPage.setPassword("Test123");
        loginPage.login();
        Assert.assertTrue(homePage.getWelcome().contains("Welcome to our store"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    }
}
