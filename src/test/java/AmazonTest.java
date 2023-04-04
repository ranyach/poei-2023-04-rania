import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.*;

public class AmazonTest {
    WebDriver driver;


    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testIphone13() {
        driver.get("https://www.amazon.fr");
        String keyword = "iPhone 13";
        HomePage homePage = new HomePage(driver);
       // SearchResultPage searchResult = new SearchResultPage(driver);
       // ProductPage productPage = new ProductPage(driver);
      //  CartPage cartPage = new CartPage(driver);

        CartPage cartPage = homePage.closeCookiePopup()
                .search(keyword)
                .openFirstProductPage()
                .addToCart();

        Assert.assertTrue(cartPage.proceedToCheckoutButtonVisibility(), "Payment button not visible");
        Assert.assertTrue(cartPage.getProductTitle().toLowerCase().contains(keyword.toLowerCase()), "The product title doesn't contain " + keyword);

    }


    @Test
    public void testZelda() {
        String expectedPrice = "54,99";
        String expectedAvailableDate = "Cet article paraîtra le 12 mai 2023.";
        driver.get("https://www.amazon.fr");

        HomePage homePage = new HomePage(driver);

        ProductPage productPage = new ProductPage(driver);

        GamesAndConsolesPage gamesAndConsolesPage = new GamesAndConsolesPage(driver);

        homePage.closeCookiePopup();
        homePage.goToSearchResultPage();
        gamesAndConsolesPage.openBestSeller(0);

        Assert.assertEquals(productPage.getPrice(), expectedPrice, "The price is not 54,99");
        Assert.assertEquals(productPage.getAvailableDate(), expectedAvailableDate, "Available date is not visible ");

    }

}
