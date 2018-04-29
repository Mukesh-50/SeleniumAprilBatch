package class13;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lib.BrowserFactory;

public class CrossBrowserTesting_advance {

	@Parameters({ "Browser","URL" })
	@Test
	public void testParameters(String browser, String appUrl) {

	WebDriver driver=BrowserFactory.getBrowser(browser, appUrl);
		
	System.out.println("CurrentURL "+driver.getCurrentUrl());
	
	}

}
