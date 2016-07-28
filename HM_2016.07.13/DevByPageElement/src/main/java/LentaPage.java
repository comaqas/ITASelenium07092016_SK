import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LentaPage {

    private static final By LOGO = By.className("header-logo");

    public static boolean isLogoPresent(WebDriver driver){
        WebElement logo = driver.findElement(LOGO);

        if(!logo.isDisplayed()){
            return false;
        }
        return true;
    }
}
