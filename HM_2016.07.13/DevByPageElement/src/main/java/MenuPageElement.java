import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPageElement {

    private static final By LENTA = By.cssSelector("[href='https://dev.by/lenta']");
    private static final By COMPANIES = By.cssSelector(".menu [href='https://companies.dev.by/']");
    private static final By SALARIES = By.cssSelector(".navigation [href='https://salaries.dev.by/']");
    private static final By VACANCIES = By.cssSelector(".menu [href='https://jobs.dev.by/']");

    public static void clickLentaInMenu(WebDriver driver){
        WebElement news = driver.findElement(LENTA);
        news.click();
    }
    public static void clickCompaniesInMenu(WebDriver driver){
        WebElement company = driver.findElement(COMPANIES);
        company.click();
    }
    public static void clickSalariesInMenu(WebDriver driver){
        WebElement salary = driver.findElement(SALARIES);
        salary.click();
    }
    public static void clickVacanciesInMenu(WebDriver driver){
        WebElement vacancy = driver.findElement(VACANCIES);
        vacancy.click();
    }
}
