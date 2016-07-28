import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalariesPage {

    private static final By SALARY_IN_IT = By.cssSelector("[class='input info-count']>h3");

    public static boolean isSalaryInItTextPresent(WebDriver driver){

        WebElement findText = driver.findElement(SALARY_IN_IT);

        if(!findText.getText().equals("Зарплата в ИТ")){
            return false;
        }
        return true;
    }


}