import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void testAmazon() {
        driver.get("https://www.amazon.fr");
    }


    @Test
    public void testGoogle() {
        driver.get("https://www.google.com");
    }

    @Test
    public void testYoutube() {
        driver.get("https://www.youtube.com");
    }
}
