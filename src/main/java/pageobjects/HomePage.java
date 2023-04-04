package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage {

    By searchBarLocator = By.cssSelector("#twotabsearchtextbox");
    By cookiesLocator = By.id("sp-cc-accept");

    By gamesAndConsoleLocator = By.cssSelector("[data-menu-id='12']");

    By allCategoriesMenuLocator = By.cssSelector("#nav-main .nav-left");

    By gamesCategoryLocator = By.cssSelector("ul.hmenu.hmenu-visible.hmenu-translateX > li a[class='hmenu-item']");

    By allGamesLocator = By.cssSelector(".hmenu-visible > li a");

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String keyword) {
        driver.findElement(searchBarLocator).sendKeys(keyword + Keys.ENTER);
    }

    public void closeCookiePopup(){
        driver.findElement(cookiesLocator).click();
    }


    public void goToSearchResultPage(){
        driver.findElement(allCategoriesMenuLocator).click();
        Utils.setExplicitWait(driver);
        Utils.wait.until(ExpectedConditions.elementToBeClickable(gamesAndConsoleLocator)).click();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElements(allGamesLocator).get(1).click();

    }
}
