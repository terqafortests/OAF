package utils;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by beetlezhuk on 11/23/15.
 */
public class ComplexReportFactory
{
    public static ExtentReports reporter;
    public static Map<Long, String> threadToExtentTestMap = new HashMap<Long, String>();
    public static Map<String, ExtentTest> nameToTestMap = new HashMap<String, ExtentTest>();

    private synchronized static ExtentReports getExtentReport()
    {
        if (reporter == null)
        {
            reporter = new ExtentReports("/home/beetlezhuk/IdeaProjects/ASAOffshore/ComplexReport.html", true, DisplayOrder.NEWEST_FIRST);
        }
        return reporter;
    }

    public synchronized static ExtentTest getTest(String testName, String testDescription) {

        // if this test has already been created return
        if (!nameToTestMap.containsKey(testName)) {
            Long threadID = Thread.currentThread().getId();
            ExtentTest test = getExtentReport().startTest(testName, testDescription);
            nameToTestMap.put(testName, test);
            threadToExtentTestMap.put(threadID, testName);
        }
        return nameToTestMap.get(testName);
    }

    public synchronized static ExtentTest getTest(String testName) {
        return getTest(testName, "");
    }

    public synchronized static ExtentTest getTest() {
        Long threadID = Thread.currentThread().getId();

        if (threadToExtentTestMap.containsKey(threadID)) {
            String testName = threadToExtentTestMap.get(threadID);
            return nameToTestMap.get(testName);
        }
        //system log, this shouldnt happen but in this crazy times if it did happen log it.
        return null;
    }

    public synchronized static void closeTest(String testName) {

        if (!testName.isEmpty()) {
            ExtentTest test = getTest(testName);
            getExtentReport().endTest(test);
        }
    }

    public synchronized static void closeTest(ExtentTest test) {
        if (test != null) {
            getExtentReport().endTest(test);
        }
    }

    public synchronized static void closeTest()  {
        ExtentTest test = getTest();
        closeTest(test);
    }

    public synchronized static void closeReport() {
        if (reporter != null) {
            reporter.flush();
            reporter.close();
        }
    }
}
