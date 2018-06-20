package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lib.Utility;

public class LogoutPage {
	
	WebDriver driver;
	
	public LogoutPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy (id = "welcome") WebElement WelcomeAdmin;
	@FindBy (xpath = "//a[text()='Logout']") WebElement Logout;
	
	public void LogoutfromApplication()
	{
		
		Utility.waitforWebElement(driver, WelcomeAdmin, 20).click();
		
		Utility.waitforWebElement(driver, Logout, 20).click();
		
	}
	

}
