package masterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.ComplexReportFactory;
import utils.ExtentManager;
import utils.SystemUtils;
import utils.WebBrowser;

import java.lang.reflect.Method;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class PageHead extends WebBrowser
{
    protected SystemUtils utils;
    protected PagesFactory factory;
//    protected WebDriver driver;
    String test_title;

//    @Parameters({"browser", "test_name"})
    @BeforeMethod
    public void setup(Method caller)//@Optional String browser, @Optional String test_name, x
    {
        this.test_title = caller.getName();
        this.utils = new SystemUtils();



        ComplexReportFactory.getTest(caller.getName(), "Very cool report");
//        this.factory = new PagesFactory(this.driver);
        this.factory = new PagesFactory(Driver());
//      this.driver.manage().window().maximize();
//        entered_values = new EnteredTestData();
//        read_keywords = new ReadExcellKeywords(driver, entered_values);
    }

    @AfterMethod
    public void tearDown(Method caller)
    {
//        this.driver.close();
//        this.driver.quit();
    }

    @AfterMethod
    public void afterSuite()
    {
        ComplexReportFactory.closeTest(test_title);
        ComplexReportFactory.closeReport();
    }
}