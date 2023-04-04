package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GamesAndConsolesPage {
    By bestSellersLocator = By.cssSelector("[cel_widget_id='handsfree-browse_OctopusBestSellerAsin'] li");

    WebDriver driver;

    public GamesAndConsolesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBestSeller(int index) {
        driver.findElements(bestSellersLocator).get(index).click();
    }
}
