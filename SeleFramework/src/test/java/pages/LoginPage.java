package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import dataProviders.DataproviderFactory;
import lib.Utility;

public class LoginPage {

	 public WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		
	 this.driver = ldriver;
	 
	}
	
	@FindBy(id="txtUsername") WebElement Username;	
	
	@FindBy(id="txtPassword") WebElement Password;
	
	@FindBy(xpath="//*[@name='Submit']") WebElement loginbutton;
	
	public void logintoCRM()
	{
		Utility.waitforWebElement(driver, Username, 30).sendKeys(DataproviderFactory.getExcel().getData(0,0,0));
		Utility.waitforWebElement(driver, Password, 30).sendKeys(DataproviderFactory.getExcel().getData(0,0,1));
		loginbutton.click();
	}
	
	public void titleBeforeLogin()
	{
       
		try {
			
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			
		}
		
		
		Assert.assertEquals("OrangeHRM",driver.getTitle());
				
	}
	
	public void titleAfterLogin()
	{
					
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		
	}
	
}
