package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertEquals;

public class MailPageFlow {
    private final By EMAIL_FIELD = By.id("mailbox__login");
    private final By DOMAIN = By.cssSelector("option[value='bk.ru']");
    private final By PASSWORD_FIELD = By.id("mailbox__password");
    private final By AUTH_BUTTON = By.id("mailbox__auth__button");
    private final By LOGOUT_BUTTON = By.id("PH_logoutLink");
    private final By MESSAGE = By.cssSelector(".b-datalist__item__addr");
    private final By NEXT_BUTTON = By.cssSelector(".ico_folder_important");

    private WebDriver driver;

    public MailPageFlow(WebDriver driver){

        this.driver=driver;
    }

    public MailPageFlow login(String loginText, String passwordText){
        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.sendKeys(loginText);

        WebElement domainCheckbox = driver.findElement(DOMAIN);
        domainCheckbox.click();

        WebElement passwordField = driver.findElement(PASSWORD_FIELD);
        passwordField.sendKeys(passwordText);

        WebElement authButton = driver.findElement(AUTH_BUTTON);
        authButton.click();

        return this;
    }

    public MailPageFlow isLogged(){
        WebElement profileButton = driver.findElement(LOGOUT_BUTTON);
        boolean isLogged = false;
        if (profileButton.isDisplayed()) {
            isLogged = true;
        }
        else {
            fail("You is not logged!");
        }
        return this;
    }

    public MailPageFlow countMessagesInBox(){
        WebElement nextButton = driver.findElement(NEXT_BUTTON);
        List<WebElement> messages = driver.findElements(MESSAGE);
        int messagesCount = messages.size();

        while (nextButton.isDisplayed() && nextButton.isEnabled()) {
            nextButton.click();
            messages = driver.findElements(MESSAGE);
            messagesCount += messages.size();
        }
        assertEquals(messagesCount, 26);
        System.out.println("Actual result: " +messagesCount + "Expected: 35");
        return this;
    }
}
