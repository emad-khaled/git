package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By searchBox = By.id("small-searchterms");
    private By searchButton = By.className("search-box-button");
    private By welcome = By.xpath("//div[@class ='topic-block-title']/h2");
    private By cartLink = By.id("topcartlink");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage navToRegister() {
        click(registerLink);
        return new RegisterPage(driver);
    }

    public LoginPage navToLogin() {
        click(loginLink);
        return new LoginPage(driver);
    }

    //Get welcome massage after login
    public String getWelcome() {
        return find(welcome).getText();
    }

   //Navigate to Shopping Cart
    public CartPage navToCart() {
        click(cartLink);
       return new CartPage(driver);
    }

   //Search for items
    public SearchPage searchItem(String searchText)
    {type(searchText, searchBox);
      click(searchButton);
        return new SearchPage(driver);
    }

}
