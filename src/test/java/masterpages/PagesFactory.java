package masterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SalesforceLoginPage;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class PagesFactory extends AbstractPage
{
    public PagesFactory(WebDriver driver)
    {
        super(driver);
    }

    public SalesforceLoginPage Salesforce_Login_Page()
    {
        return PageFactory.initElements(driver, SalesforceLoginPage.class);
    }
}
