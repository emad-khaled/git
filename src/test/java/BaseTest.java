import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BaseTest {
protected WebDriver driver ;
protected HomePage homePage;

private final String url ="https://demo.nopcommerce.com/";
    @BeforeClass
    public void setup(){
    driver = new ChromeDriver();
    homePage= new HomePage(driver);
    driver.get(url);
    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
