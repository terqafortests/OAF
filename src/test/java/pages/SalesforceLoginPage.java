package pages;

import com.relevantcodes.extentreports.LogStatus;
import masterpages.AbstractPage;
import masterpages.PageUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class SalesforceLoginPage extends AbstractPage
{

    public SalesforceLoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindAll({@FindBy(id = "username"), @FindBy(name = "username")})
    WebElement username_txt;

    @FindAll({@FindBy(id = "password"), @FindBy(name = "password")})
    WebElement password_txt;

    @FindBy(name = "Login")
    WebElement login_btn;


    public SalesforceLoginPage Open()
    {
        super.navigate_to(PageUrls.SALESFORCE_LOGIN_PAGE);

        return this;
    }

    public SalesforceLoginPage Enter_Username(String usr)
    {
            waitForElementPresent(username_txt, 5);
            username_txt.sendKeys(usr);
            extent_test.log(LogStatus.INFO, "Username entered: '" + usr + "'");

        return this;
    }

    public SalesforceLoginPage Enter_Password(String pass)
    {
        waitForElementPresent(password_txt, 5);
        password_txt.sendKeys(pass);
        extent_test.log(LogStatus.INFO, "Password entered: '" + pass + "'");

        return this;
    }

    public SalesforceLoginPage Click_On_Login_Btn()
    {
        waitForElementPresent(login_btn, 2);
        login_btn.click();
        extent_test.log(LogStatus.PASS, "Login button clicked");

        return this;
    }

    public SalesforceLoginPage Verify_User_Is_Logged_In()
    {
        super.sleep(2000);
        super.PageReached(PageUrls.SALESFORCE_HOME_PAGE);

        return this;
    }
}
