package masterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MyLearningPage;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class PagesFactory extends AbstractPage
{
    public PagesFactory(WebDriver driver)
    {
        super(driver);
    }

    public LoginPage login_page()
    {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public MyLearningPage my_learning_page()
    {
        return PageFactory.initElements(driver, MyLearningPage.class);
    }
}
