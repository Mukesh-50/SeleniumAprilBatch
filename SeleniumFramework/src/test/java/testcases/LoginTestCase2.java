package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BaseClass;
import pages.LoginPage;
import pages.LogoutPage;

public class LoginTestCase2 extends BaseClass
{

	LoginPage login;
	LogoutPage logout;
	
	@Parameters({"uname","pass"})
	@Test
	public void login(String uname,String pass)
	{
		logger=report.startTest("Login", "This test case will verify valid login");
		
		login=PageFactory.initElements(driver, LoginPage.class);
		
		login.verifyTitleBeforeLogin();
		
		logger.log(LogStatus.INFO, "Login page appeared");
	
		login.loginToCRM(uname,pass);
		
		login.verifyTitleAfterLogin();
		
		logger.log(LogStatus.PASS, "Title Verified"); 
		
	}
	
	@Test(dependsOnMethods="login")
	public void logout()
	{
		logger=report.startTest("Logout", "This test case will logut from app");
		
		logout=PageFactory.initElements(driver, LogoutPage.class);
		
		logout.logOutFromApplication();
		
		login.verifyTitleBeforeLogin();
		
		logger.log(LogStatus.PASS, "Logout done Successfully");
		
	}
	
	
}
