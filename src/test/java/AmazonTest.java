import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.CartPage;
import pageobjects.HomePage;
import pageobjects.ProductPage;
import pageobjects.SearchResultPage;

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
    public void testiphone13() {
        driver.get("https://www.amazon.fr");
        String keyword = "iPhone 13";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResult = new SearchResultPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.closeCookiePopup();
        homePage.search(keyword);

        searchResult.openFirstProductPage();

        productPage.addToCart();
        productPage.refuseInsurance();
        productPage.openCart();

        Assert.assertTrue(cartPage.proceedToCheckoutButtonVisibility(), "Payment button not visible");
        Assert.assertTrue(cartPage.getProductTitle().toLowerCase().contains(keyword.toLowerCase()), "The product title doesn't contain " + keyword);

    }

}
