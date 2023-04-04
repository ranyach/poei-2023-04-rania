package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage {

    By addToCartButtonLocator = By.cssSelector("input#add-to-cart-button");

    By NoThanksButtonLocator = By.cssSelector("#attachSiNoCoverage");

    By cartButtonLocator = By.cssSelector("#attach-sidesheet-view-cart-button");

    By availabilityLocator = By.cssSelector("#availability span");

    By integerPriceLocator = By.cssSelector("span.a-price.aok-align-center span span.a-price-whole");
    By decimalPriceLocator = By.cssSelector("span.a-price.aok-align-center span span.a-price-fraction");
    WebDriver driver;




    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public CartPage addToCart(){
        driver.findElement(addToCartButtonLocator).click();
        this.refuseInsurance();
        this.openCart();
        return new CartPage(driver);
    }

    public void refuseInsurance(){
        Utils.setExplicitWait(driver);
        Utils.wait.until(ExpectedConditions.elementToBeClickable(NoThanksButtonLocator)).click();

    }
    public void openCart(){
        Utils.setExplicitWait(driver);
        Utils.wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator)).click();
    }

    public String getAvailableDate(){

       return driver.findElement(availabilityLocator).getText();
    }

    public String getPrice(){

        return driver.findElement(integerPriceLocator).getText() + "," + driver.findElement(decimalPriceLocator).getText() ;
    }
}
