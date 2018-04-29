package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lib.Utility;

public class LogoutPage 
{
	WebDriver driver;

	 public LogoutPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	
	@FindBy(id="welcome") WebElement welcomeAdmin;
	
	@FindBy(xpath="//a[text()='Logout']") WebElement logout;
	
	
	public void logOutFromApplication()
	{
		Utility.waitForWebElement(driver, welcomeAdmin, 20).click();
		Utility.waitForWebElement(driver, logout, 20).click();
	}
	
}
