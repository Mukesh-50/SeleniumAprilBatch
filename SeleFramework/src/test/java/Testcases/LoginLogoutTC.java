package Testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.Baseclass;
import pages.LoginPage;
import pages.LogoutPage;

	public class LoginLogoutTC extends Baseclass {
		
	    LoginPage login;
	    LogoutPage logout;
	   
		@Parameters({"uname","pass"})	
		@Test
		public void login(String uname,String pass)
		{
			logger = report.startTest("login", "This Test is to verify to login");
			
			LoginPage login = PageFactory.initElements(driver, LoginPage.class);
			
			login.titleBeforeLogin();
			
			logger.log(LogStatus.INFO, "Login Page appeared");
			
			login.logintoCRM(uname,pass);
			
			login.titleAfterLogin();
			
			logger.log(LogStatus.PASS, "Title Verified" );
									
		}
		
		
	@Test(dependsOnMethods="login")
	public void logout()
	{
		
		logger = report.startTest("logout", "This Test is to verify to logout");
		
		LogoutPage logout = PageFactory.initElements(driver, LogoutPage.class);
					
		logout.LogoutfromApplication();
		
		logger.log(LogStatus.PASS, "Logout succesfully done");
		
		
		//login.titleBeforeLogin();
 
	}

}