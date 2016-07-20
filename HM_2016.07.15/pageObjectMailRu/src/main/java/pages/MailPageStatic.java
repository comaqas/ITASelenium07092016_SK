package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailPageStatic {
    private static final By EMAIL_FIELD = By.id("mailbox__login");
    private static final By DOMAIN = By.cssSelector("option[value='bk.ru']");
    private static final By PASSWORD_FIELD = By.id("mailbox__password");
    private static final By AUTH_BUTTON = By.id("mailbox__auth__button");
    private static final By LOGOUT_BUTTON = By.id("PH_logoutLink");
    private static final By MESSAGE = By.cssSelector(".b-datalist__item__addr");
    private static final By NEXT_BUTTON = By.cssSelector(".ico_folder_important");

    public static void login(WebDriver driver, String loginText, String passwordText){
        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(loginText);

        WebElement domainCheckbox = driver.findElement(DOMAIN);
        domainCheckbox.click();

        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(passwordText);

        WebElement authButton = driver.findElement(AUTH_BUTTON);
        authButton.click();

    }

    public static boolean isLogged(WebDriver driver){
        WebElement profileButton = driver.findElement(LOGOUT_BUTTON);
        if (profileButton.isDisplayed()) {
            return true;
        }
        return false;
    }

    public static int countMessagesInBox(WebDriver driver){
        WebElement nextButton = driver.findElement(NEXT_BUTTON);
        List<WebElement> messages = driver.findElements(MESSAGE);
        int messagesCount = messages.size();

        while (nextButton.isDisplayed() && nextButton.isEnabled()) {
            nextButton.click();
            messages = driver.findElements(MESSAGE);
            messagesCount = messagesCount + messages.size();
        }
        return messagesCount;
    }
}
