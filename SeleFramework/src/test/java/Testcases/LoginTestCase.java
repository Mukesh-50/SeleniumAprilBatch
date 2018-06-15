package Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import lib.Utility;
import pages.Baseclass;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTestCase extends Baseclass {
	
	@Test
	public void login()
	{
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		LogoutPage logout = PageFactory.initElements(driver, LogoutPage.class);
		
		Utility.waitforTitle(driver, "OrangeHRM", 30);
		
		login.logintoCRM();
		
		Utility.waitforURLContains(driver,"dashboard", 30);
				
		logout.LogoutfromApplication();
		
		Utility.waitforTitle(driver, "OrangeHRM", 30);
		
	}
	

}
