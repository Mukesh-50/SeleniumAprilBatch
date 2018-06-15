package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	
	@FindBy (id = "welcome") WebElement WelcomeAdmin;
	@FindBy (xpath = "//a[text()='Logout']") WebElement Logout;
	
	public void LogoutfromApplication()
	{
		
		WelcomeAdmin.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		
		Logout.click();
		
	}
	

}
