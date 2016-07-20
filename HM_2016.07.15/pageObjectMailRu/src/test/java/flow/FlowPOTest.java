package flow;

import core.TestBase;
import org.testng.annotations.Test;
import pages.MailPageFlow;

public class FlowPOTest extends TestBase {

    @Test
    public void flowTest(){
        MailPageFlow page = new MailPageFlow(driver);

        page
                .login("strong.zubovich", "ZXCvbn123!")
                .isLogged()
                .countMessagesInBox();
    }
}