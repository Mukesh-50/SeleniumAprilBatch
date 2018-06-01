package class13;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lib.BrowserFactory;

public class crossbrowser_advance {

	@Parameters({"Browser","URL"})
	@Test
	public void testparameters(String browser,String appurl) 
	{
		
		WebDriver driver = BrowserFactory.getBrowser(browser, appurl);
		
		System.out.println("Current URL"+driver.getCurrentUrl());
		
		BrowserFactory.closeBrowser(driver);
	  	
		
    }
	
}
