package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static WebDriverWait wait;
    final static int TIMEOUT_SIDE_PANEL = 5;
    public static void setExplicitWait(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SIDE_PANEL));
    }
}
