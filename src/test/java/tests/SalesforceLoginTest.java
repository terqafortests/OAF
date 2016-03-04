package tests;

import masterpages.PageHead;
import org.testng.annotations.Test;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class SalesforceLoginTest extends PageHead
{
    @Test
    public void Test_Salesforce_Login()
    {
        factory.Salesforce_Login_Page().
                Open().
                Enter_Username("adminlite.user.offshoreqa777@yahoo.com.ies.qa").
                Enter_Password("Qwerty2@").
                Click_On_Login_Btn().
                Verify_User_Is_Logged_In();
    }
}
