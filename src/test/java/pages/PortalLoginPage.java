package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

import masterpages.AbstractPage;
import utils.ComplexReportFactory;

public class PortalLoginPage extends AbstractPage{
	
	ExtentTest test_reporter;

	public PortalLoginPage(WebDriver driver) {
		super(driver);
        test_reporter = ComplexReportFactory.getTest();
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement login;
	
	public PortalLoginPage login(String uname, String pass){
		driver.get("https://bpp-test.apolloglobal.int/ncas/login?service=https://bpp-fusion-test.apolloglobal.int/delegate/fusion-loginconfirm");
		username.sendKeys(uname);
		password.sendKeys(pass);
		login.click();
		return this;
	}
	
	public PortalLoginPage verifyIfLoggedIn(){
		Assert.assertEquals(driver.getCurrentUrl(), "http://bpp-fusion-test.apolloglobal.int/group/student");
		return this;
	}
	
	
	

}
