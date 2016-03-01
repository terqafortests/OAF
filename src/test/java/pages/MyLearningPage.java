package pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import masterpages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.ComplexReportFactory;

import java.util.List;

/**
 * Created by beetlezhuk on 11/22/15.
 */
public class MyLearningPage extends AbstractPage
{
    ExtentTest test_reporter;

    public MyLearningPage(WebDriver driver)
    {
        super(driver);
        test_reporter = ComplexReportFactory.getTest();
    }

    @FindBy(id = "iframe-layout-instance")
    WebElement available_papers_iframe;

    @FindBy(tagName = "label")
    private List<WebElement> course_radios;

    @FindBy(id = "open_button")
    private WebElement open_btn;

    @FindBy(id = "logout_button")
    private WebElement logout_btn;

    @FindBy(xpath = "//*[@id='region-main']/div[3]/div/div[1]/h1")
    private WebElement course_title;

    public MyLearningPage SelectCourse(String title)
    {
        get_frame(available_papers_iframe);
        get_course(title).click();


        return this;
    }

    public MyLearningPage ClickOnOpenButton()
    {
        open_btn.click();
        test_reporter.log(LogStatus.PASS, "Open button is clicked");

        return this;
    }

    public MyLearningPage ClickOnLogoutButton()
    {
        logout_btn.click();
        test_reporter.log(LogStatus.PASS, "Logout button is clicked");

        return this;
    }

    public MyLearningPage CourseDetailsAreShown()
    {
        sleep(3000);
        Assert.assertTrue(course_title.isDisplayed());
        test_reporter.log(LogStatus.PASS, "Course is opened");

        return this;
    }

    private WebElement get_course(String course_title)
    {
        WebElement element = null;

        for(int i = 0; i < this.course_radios.size(); i++)
        {
            if(this.course_radios.get(i).getText().contains(course_title))
            {
                element = this.course_radios.get(i);
                break;
            }
        }

        return element;
    }
}
