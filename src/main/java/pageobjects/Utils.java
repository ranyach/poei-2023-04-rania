package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static WebDriverWait wait;

    public static void setExplicitWait(WebDriver driver, long duration){
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
    }
}
