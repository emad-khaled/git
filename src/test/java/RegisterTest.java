
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegisterTest extends BaseTest{
    private RegisterPage registerPage;
    @Test
    public void validRegisterTest()  {
        registerPage= homePage.navToRegister();
        registerPage.setFirstname("Ahmed");
        registerPage.setLastname("elbaily");
        registerPage.selectBirthDay("20");
        registerPage.selectBirthMonth("January");
        registerPage.selectBirthYear("1998");
        registerPage.setEmail("testp@gmail.com");
        registerPage.setPassword("Test123");
        registerPage.setConfirmPassword("Test123");
        registerPage.clickRegister();
        Assert.assertTrue(registerPage.getConfirmationMassage().contains("Your registration completed"));
    }
}

