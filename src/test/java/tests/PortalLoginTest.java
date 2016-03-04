package tests;

import org.testng.annotations.Test;

import masterpages.PageHead;

public class PortalLoginTest extends PageHead {
  @Test
  public void Test_Portal_Login() {
	  
	  factory.Portal_Login_Page().
	  login("a.AKSTpLastDQ", "Ak081915").
	  verifyIfLoggedIn();
	  
  }
}
