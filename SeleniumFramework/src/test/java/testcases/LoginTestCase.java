package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import lib.Utility;
import pages.BaseClass;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTestCase extends BaseClass
{

	@Test
	public void login()
	{

		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
		
		Utility.waitforTitle(driver,"OrangeHRM", 30);
		
		login.loginToCRM("","");
		
		Utility.waitforURLContains(driver, "dashboard", 30);
		
		logout.logOutFromApplication();
		
		Utility.waitforTitle(driver,"OrangeHRM", 30);
		
	}
	
	
}
