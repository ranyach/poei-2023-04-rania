package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    By searchResultList = By.cssSelector("div.s-product-image-container");
    WebDriver driver;

    public SearchResultPage(WebDriver driver){
        this.driver= driver;
    }

    public ProductPage openFirstProductPage(){
        driver.findElements(searchResultList).get(0).click();
        return new ProductPage(driver);
    }
}
