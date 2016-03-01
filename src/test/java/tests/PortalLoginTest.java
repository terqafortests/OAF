package tests;

import masterpages.PageHead;
import masterpages.PageUrls;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class PortalLoginTest extends PageHead
{
//    @Parameters({"username", "password"})
    @Test
    public void TestLogin()
    {
            factory.login_page().
                    open().
                    EnterUsername("fsdfsdf").
                    EnterPassword("sdfdsf").
                    ClickOnLoginBtn();
    }
}
