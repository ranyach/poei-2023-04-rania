package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage {

    By addToCartButtonLocator = By.cssSelector("input#add-to-cart-button");

    By NoThanksButtonLocator = By.cssSelector("#attachSiNoCoverage");

    By cartButtonLocator = By.cssSelector("#attach-sidesheet-view-cart-button");
    WebDriver driver;




    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(addToCartButtonLocator).click();
    }

    public void refuseInsurance(){
        Utils.setExplicitWait(driver);
        Utils.wait.until(ExpectedConditions.elementToBeClickable(NoThanksButtonLocator)).click();

    }
    public void openCart(){
        Utils.setExplicitWait(driver);
        Utils.wait.until(ExpectedConditions.elementToBeClickable(cartButtonLocator)).click();
    }
}
