package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import masterpages.AbstractPage;
import masterpages.PageUrls;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.ComplexReportFactory;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class LoginPage extends AbstractPage
{
    ExtentTest test_reporter;
    String default_url = "http://bpp-fusion-test.apolloglobal.int";

    public LoginPage(WebDriver driver)
    {
        super(driver);
        test_reporter = ComplexReportFactory.getTest();
    }

    @FindAll({@FindBy(id = "username"), @FindBy(name = "username")})
    WebElement username_txt;

    @FindAll({@FindBy(id = "password"), @FindBy(name = "password")})
    WebElement password_txt;

    @FindBy(name = "Login")
    WebElement login_btn;


    public LoginPage open()
    {
        super.navigate_to(PageUrls.LOGIN_PAGE);
        sleep(3000);

        return this;
    }

    public LoginPage EnterUsername(String usr)
    {
            waitForElementPresent(username_txt, 5000);
            username_txt.sendKeys(usr);
//            test_reporter.log(LogStatus.INFO, "Username entered");

        return this;
    }

    public LoginPage EnterPassword(String pass)
    {
        waitForElementPresent(password_txt, 5000);
        password_txt.sendKeys(pass);
//        test_reporter.log(LogStatus.PASS, "Password entered: '" + pass + "'");

        return this;
    }

    public LoginPage ClickOnLoginBtn()
    {
        waitForElementPresent(login_btn, 2000);
        login_btn.click();
//        test_reporter.log(LogStatus.PASS, "Login button clicked");

        return this;
    }
}
