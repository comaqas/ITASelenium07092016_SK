package pageFactory;

import core.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.MailPageDynamic;
import pages.MailPageSimpleFactory;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;


public class PageFactoryPOTest extends TestBase {

    @Test
    public void mailTest(){

        MailPageSimpleFactory page = PageFactory.initElements(driver, MailPageSimpleFactory.class);

        String loginText = "strong.zubovich";
        String passwordText = "ZXCvbn123!";

        page.login(loginText, passwordText);
        assertTrue(page.isLogged());

        page.countMessagesInBox();
        assertEquals(page.countMessagesInBox(), 35);

        System.out.println("Количество писем: " + page.countMessagesInBox());
    }
}