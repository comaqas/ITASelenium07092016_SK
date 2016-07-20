package staticTest;

import core.TestBase;
import org.testng.annotations.Test;
import pages.MailPageStatic;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class StaticPOTest extends TestBase {

    @Test
    public void mailTest(){

        String loginText = "strong.zubovich";
        String passwordText = "ZXCvbn123!";

        MailPageStatic.login(driver, loginText, passwordText);
        assertTrue(MailPageStatic.isLogged(driver));

        MailPageStatic.countMessagesInBox(driver);
        assertEquals(MailPageStatic.countMessagesInBox(driver), 26);

        System.out.println("Количество писем: " + MailPageStatic.countMessagesInBox(driver));
    }
}