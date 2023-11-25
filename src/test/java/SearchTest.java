import Pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    SearchPage searchPage;
    @Test
    public void invalidSearchTest()  {
        homePage.searchItem("");
        driver.switchTo().alert().accept();
    }
    @Test
    public void searchResultTest() {
        searchPage= homePage.searchItem("Apple");
        Assert.assertTrue(searchPage.isItemsDisplayed());
        Assert.assertTrue(searchPage.searchForItemName("Apple"));
    }


}
