package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailPageDynamic {

    private final By EMAIL_FIELD = By.id("mailbox__login");
    private final By DOMAIN = By.cssSelector("option[value='bk.ru']");
    private final By PASSWORD_FIELD = By.id("mailbox__password");
    private final By AUTH_BUTTON = By.id("mailbox__auth__button");
    private final By LOGOUT_BUTTON = By.id("PH_logoutLink");
  //  private final By PROFILE_BUTTON = By.cssSelector(".x-ph__menu__button__text_auth");
    private final By MESSAGE = By.cssSelector(".b-datalist__item__addr");
    private final By NEXT_BUTTON = By.cssSelector(".ico_toolbar_arrow_right");

    private WebDriver driver;

    public MailPageDynamic(WebDriver driver){

        this.driver=driver;
    }

    public void login(String loginText, String passwordText){
        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(loginText);

        WebElement domainCheckbox = driver.findElement(DOMAIN);
        domainCheckbox.click();

        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(passwordText);

        WebElement authButton = driver.findElement(AUTH_BUTTON);
        authButton.click();

    }

    public boolean isLogged(){
        WebElement profileButton = driver.findElement(LOGOUT_BUTTON);
        if (profileButton.isDisplayed()) {
            return true;
        }
        return false;
    }

    public int countMessagesInBox(){
        WebElement nextButton = driver.findElement(NEXT_BUTTON);
        List<WebElement> messages = driver.findElements(MESSAGE);
        int messagesCount = messages.size();

        while (nextButton.isDisplayed() && nextButton.isEnabled()) {
            nextButton.click();
            messages = driver.findElements(MESSAGE);
            messagesCount += messages.size();
        }
        return messagesCount;
    }
}
