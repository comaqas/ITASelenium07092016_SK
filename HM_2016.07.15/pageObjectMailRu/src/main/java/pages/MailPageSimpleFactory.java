package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MailPageSimpleFactory {

    @FindBy(id = "mailbox__login")
    private WebElement emailField;

    @FindBy(css = "option[value='bk.ru']")
    private WebElement domainCheckbox;

    @FindBy(id = "mailbox__password")
    private WebElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    private WebElement authButton;

    @FindBy(id = "PH_logoutLink")
    private WebElement profileButton;

    @FindBy(css = ".b-datalist__item__addr")
    private List<WebElement> messages;

    @FindBy(css = ".ico_folder_important")
    private WebElement nextButton;

    public void login(String loginText, String passwordText){
        emailField.sendKeys(loginText);
        domainCheckbox.click();
        passwordField.sendKeys(passwordText);
        authButton.click();
    }

    public boolean isLogged(){

        if (profileButton.isDisplayed()) {
            return true;
        }
        return false;
    }

    public int countMessagesInBox(){

        int messagesCount = messages.size();

        while (nextButton.isDisplayed() && nextButton.isEnabled()) {
            nextButton.click();
            messagesCount = messagesCount + messages.size();
        }
        return messagesCount;
    }
}
