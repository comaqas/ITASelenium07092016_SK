package dynamic;

import core.TestBase;
import org.testng.annotations.Test;
import pages.MailPageDynamic;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class DynamicPOTest extends TestBase{

    @Test
    public void mailTest(){
        MailPageDynamic page = new MailPageDynamic(driver);

        String loginText = "strong.zubovich";
        String passwordText = "ZXCvbn123!";

        page.login(loginText, passwordText);
        assertTrue(page.isLogged());

        page.countMessagesInBox();
        assertEquals(page.countMessagesInBox(), 26);

    System.out.println("Количество писем: " + page.countMessagesInBox());
    }
}
