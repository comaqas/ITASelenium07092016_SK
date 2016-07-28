import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompaniesPage {

    private static final By ISSOFT = By.cssSelector("[href = '/issoft']");

    public static boolean isIsSoftPresent(WebDriver driver){

        WebElement isSoft = driver.findElement(ISSOFT);

        if (!isSoft.isDisplayed()){
            return false;
        }
        return true;
    }
}

