package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.BaseClass;
import pages.ContactPage;
import pages.LoginPage;
import pages.LogoutPage;

public class AddContacts extends BaseClass{

	
	@Parameters({"uname","pass"})
	@Test
	public void addContactAndValidate(String uname,String pass)
	{
	
	logger=report.startTest("Add Contact in CRM", "This test case will add contacts in CRM");
		
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
	
	ContactPage contact=PageFactory.initElements(driver, ContactPage.class);
	
	LogoutPage logOut=PageFactory.initElements(driver, LogoutPage.class);
	
	login.loginToCRM(uname, pass);
	
	logger.log(LogStatus.INFO, "Login Done");
	
	contact.navigateToContactPage();
	
	logger.log(LogStatus.INFO, "landed to contact page");
	
	contact.addContact("Kabir5009", "Kabir5009");
	
	logger.log(LogStatus.INFO, "Contact added");
	
	contact.validateContactAdded();
	
	logger.log(LogStatus.PASS, "user validated");
	
	logOut.logOutFromApplication();
	
	logger.log(LogStatus.INFO, "User is logged off");
	
	}
	
	
}
