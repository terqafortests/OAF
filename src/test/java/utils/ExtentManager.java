package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.io.File;

/**
 * Created by beetlezhuk on 11/22/15.
 */
public class ExtentManager
{
    static ExtentReports reporter;
    static ExtentTest test;

    public static synchronized ExtentReports Instance()
    {
        SystemUtils utils = new SystemUtils();

        String report_path = "/home" + File.separator + "beetlezhuk" + File.separator + "IdeaProjects" + File.separator +
                "AZFR" + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator +
                "reports" + File.separator + "extentr" + File.separator;
        System.out.println(report_path);
        reporter = new ExtentReports(report_path + utils.get_date(), false);
        reporter.config()
                .documentTitle("Automation Report")
                .reportName("Regression");

        return reporter;
    }

    public static void SetTestInstance(String name)
    {
//        synchronized (Instance())
//        {
            test = Instance().startTest(name);
//        }
    }

    public static ExtentReports GetReporter()
    {
        return reporter;
    }

    public static ExtentTest GetTest()
    {
        return test;
    }
}
