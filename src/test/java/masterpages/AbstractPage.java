package masterpages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ComplexReportFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beetlezhuk on 11/19/15.
 */
public class AbstractPage extends PageHead
{
    protected WebDriver driver;
    protected ExtentTest extent_test;

    public AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        this.extent_test = ComplexReportFactory.getTest();
    }

//    public AbstractPage(WebDriver driver, ExtentTest extent_test)
//    {
//        this.driver = driver;
////        this.extent_test = extent_test;
////        System.out.println(extent_test.getTest().name);
//    }

//    //Finds links by text
//    protected WebElement find_link_by_custom_text(String value)
//    {
//        WebElement element = null;
//
//        try
//        {
//            this.implicit_wait(10);
//            element = this.driver.findElement(By.partialLinkText(value));
//        }
//        catch(ElementNotVisibleException e)
//        {
//            e.printStackTrace();
//        }
//
//        return element;
//    }
//
//    //Returns Select object
//    protected Select get_select(WebElement element)
//    {
//        Select select = null;
//
//        try
//        {
//            select = new Select(element);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return select;
//    }
//
//    //Selects multiple values in drop down
//    protected void select_multiselect(WebElement select, List<String> select_values)
//    {
//        Select dropdown = this.get_select(select);
//
//        try
//        {
//            for(String item : select_values)
//            {
//                dropdown.selectByVisibleText(item);
//            }
//        }
//        catch(ElementNotVisibleException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    //Accepts alerts
//    protected void accept_alert()
//    {
//        try
//        {
//            this.implicit_wait(0);
//            Alert alert = this.driver.switchTo().alert();
//            alert.accept();
//            Thread.sleep(2000);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    protected void implicit_wait(long time)
//    {
//        this.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//    }
//
    protected void waitForElementPresent(final WebElement element, int timeout)
    {
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, timeout)
                .ignoring(StaleElementReferenceException.class);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return element.isDisplayed();
            }
        });
    }
//
    //Sleeps
    protected void sleep(long time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public void PageReached(PageUrls url)
    {
        Assert.assertEquals(get_curr_url(), url.GetEnumPageUrl().toString());
    }
//
//    //Refreshes pages
//    public void page_refresh()
//    {
//        this.driver.navigate().refresh();
//    }
//
//    //Goes back
//    public void go_back()
//    {
//        this.driver.navigate().back();
//        this.sleep(4000);
//    }
//

    //Opens URL
    public void navigate_to(PageUrls url)
    {
            this.driver.get(url.GetEnumPageUrl().toString());
            extent_test.log(LogStatus.INFO, "Opened url: '" + url.GetEnumPageUrl().toString() + "'");
    }

    //Opens URL
//    public void navigate_to(String url)
//    {
//        this.driver.get(url);
//        extent_test.log(LogStatus.INFO, "Opened url: " + url);
//    }
//

//
//    //Returns Action object
//    protected Actions get_action()
//    {
//        Actions actions = new Actions(this.driver);
//        return actions;
//    }
//
    //Return a list of active tabs
    protected List<String> get_window_handles()
    {
        List<String> tabs = new ArrayList<String>(this.driver.getWindowHandles());
        return tabs;
    }

    //Returns textfield text
    protected String get_text(WebElement element)
    {
        return element.getAttribute("value");
    }

    //Returns page title
    protected String get_title()
    {
        return this.driver.getTitle();
    }

    protected String get_curr_url()
    {
        return this.driver.getCurrentUrl();
    }

    //Gets frame
    protected void get_frame(WebElement element)
    {
        driver.switchTo().frame(element);
    }

    //Return to Default content
    protected void get_default_content()
    {
        this.driver.switchTo().defaultContent();
    }

//    //Compares two objects
//    protected boolean compare_objects(Object expected, Object actual)
//    {
//        boolean passed = false;
//
//        if(expected.equals(actual))
//        {
//            passed = true;
//        }
//        else
//        {
//
//        }
//
//        return passed;
//    }
//
//    //Takes screenshot
//    protected void take_screen(String file_name)
//    {
//        try
//        {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//            FileUtils.moveFile(scrFile, new File(utils.get_app_root() + File.separator + "src" +
//                    File.separator + "gather_student_info" + File.separator + "resources" + File.separator +
//                    "screenshots" + File.separator + file_name + ".png"));
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    //Checks if element is present
//    protected boolean is_present(WebElement element)
//    {
//        boolean present = false;
//
//        try
//        {
//            sleep(1000);
//
//            if(element.isDisplayed())
//            {
//                present = true;
//            }
//            else
//            {
//
//            }
//        }
//        catch(NoSuchElementException e)
//        {
//            System.out.println("Element is not found");
//        }
//
//        return present;
//    }
//
//    //Checks if elements are present in list
//    protected boolean are_present(List<WebElement> elements)
//    {
//        boolean flag = false;
//
//        try
//        {
//            if(elements.size() > 0)
//            {
//                flag = true;
//            }
//            else
//            {
//                flag = false;
//            }
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        return flag;
//    }
//
//    //Outputs fields values to .xls file
//    public void log_to_excel(UserObject info, String migr_info, String pii_info, String field_name)
//    {
//        String path = utils.default_locations() + "Log.xls";
//        File filep = new File(path);
//
//        try
//        {
//            if(!(filep.exists()))
//            {
//                this.create_sheet();
//            }
//
//            FileInputStream file = new FileInputStream(filep);
//            HSSFWorkbook workbook = new HSSFWorkbook(file);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Cell cell = null;
//
//            HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
//
//            cell = row.createCell(row.getLastCellNum() + 2);
//            cell.setCellValue(field_name);
//
//            cell = row.createCell(row.getLastCellNum());
//            cell.setCellValue(migr_info);
//
//            cell = row.createCell(row.getLastCellNum());
//            cell.setCellValue(pii_info);
//
//            file.close();
//
//            FileOutputStream outFile = new FileOutputStream(filep);
//            workbook.write(outFile);
//            outFile.close();
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    //Creates .xls sheet if doesn't exist
//    public void create_sheet()
//    {
//        String path = utils.default_locations() + "Log.xls";
//        File file = new File(path);
//
//        try
//        {
//            HSSFWorkbook workbook = new HSSFWorkbook();
//            HSSFSheet sheet = workbook.createSheet("Sample sheet");
//
//            //Create a new row in current sheet
//            Row row = sheet.createRow(0);
//
//            //Create a new cell in current row
//            Cell cell = row.createCell(0);
//            cell.setCellValue("User");
//
//            cell = row.createCell(row.getLastCellNum());
//            cell.setCellValue("Field title");
//
//            cell = row.createCell(row.getLastCellNum());
//            cell.setCellValue("Migration data");
//
//            cell = row.createCell(row.getLastCellNum());
//            cell.setCellValue("PII data");
//
//            row = sheet.createRow(1);
//
//            FileOutputStream fileOut = new FileOutputStream(path);
//            workbook.write(fileOut);
//            fileOut.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    //Outputs info to .xls file
//    public void log_info(String account_name)
//    {
//        String path = utils.default_locations() + "Log.xls";
//        File filep = new File(path);
//
//        try
//        {
//            if(!(filep.exists()))
//            {
//                this.create_sheet();
//            }
//
//            FileInputStream file = new FileInputStream(filep);
//            HSSFWorkbook workbook = new HSSFWorkbook(file);
//            HSSFSheet sheet = workbook.getSheetAt(0);
//            Cell cell = null;
//
//            HSSFRow empty_row = sheet.createRow(sheet.getLastRowNum() + 1);
//            HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
//            cell = row.createCell(0);
//            cell.setCellValue(account_name);
//
//            FileOutputStream fileOut = new FileOutputStream(path);
//            workbook.write(fileOut);
//            fileOut.close();
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
}
