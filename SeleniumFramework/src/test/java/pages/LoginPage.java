package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import dataProviders.DataProviderFactory;
import lib.Utility;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(id = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement password;

	@FindBy(xpath = "//*[@value='LOGIN']")
	WebElement loginButton;

	public void loginToCRM() 
	{
		
		Utility.waitForWebElement(driver, username, 20).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 0));
		Utility.waitForWebElement(driver, password, 20).sendKeys(DataProviderFactory.getExcel().getData(0, 0, 1));
		Utility.waitForWebElement(driver, loginButton, 20).click();
	}

	public void verifyTitleBeforeLogin() 
	{
		
		try 
		{
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		
		Assert.assertEquals("OrangeHRM", driver.getTitle());
	}

	public void verifyTitleAfterLogin() {

		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e) {

		}
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

}
