package masterpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.ComplexReportFactory;
import utils.SystemUtils;

import java.lang.reflect.Method;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class PageHead
{
    protected SystemUtils utils;
    protected PagesFactory factory;
    protected WebDriver driver;
    protected String mvn_browser_param;
    protected String browser;
    protected String test_title;
    private static ThreadLocal<WebDriver> threadLocalDriver;

    @Parameters({"xml_browser"})
    @BeforeMethod
    public void setup(@Optional (value = "Firefox") String xml_browser, Method caller)
    {
        test_title = caller.getName().replace("_", " ");
        mvn_browser_param = String.valueOf(System.getProperty("browser"));

        if(mvn_browser_param != null)
        {
            browser = mvn_browser_param;
        }
        else
        {
            browser = xml_browser;
        }
        this.utils = new SystemUtils();

        if (browser.equalsIgnoreCase("Firefox"))
        {
            driver = new FirefoxDriver();
            System.out.println("Firefox has started");
        }
        else if (browser.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", utils.get_chrome_path());
            driver = new ChromeDriver();
            System.out.println("Chrome has started");
        }
//        else if (browser.equalsIgnoreCase("IE"))
//        {
//            System.setProperty("webdriver.ie.driver", "./resources/IEDriverServer.exe");
//            driver = new InternetExplorerDriver();
//        }
//        else if (browser.equalsIgnoreCase("Opera"))
//        {
//            System.setProperty("webdriver.opera.driver", utils.get_opera_path());
//            driver = new OperaDriver();
//        }
        else
        {
            System.setProperty("webdriver.chrome.driver", utils.get_chrome_path());
            driver = new ChromeDriver();
            System.out.println("Chrome has started");
        }
        driver.manage().window().maximize();

        ComplexReportFactory.getTest(test_title);
        this.factory = new PagesFactory(driver);

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