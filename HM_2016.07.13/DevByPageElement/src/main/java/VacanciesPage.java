import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VacanciesPage {

    private static final By VACANCIES_TEXT = By.cssSelector(".column-left>h3");

    public static boolean isVacanciesTextPresent(WebDriver driver){

        WebElement vacanciesText = driver.findElement(VACANCIES_TEXT);

        if(!vacanciesText.getText().equals("Поиск вакансий:")){
            return false;
        }
        return true;
    }
}
