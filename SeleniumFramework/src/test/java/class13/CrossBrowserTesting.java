package class13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	@Parameters({ "Browser", "URL" })
	@Test
	public void testParameters(String browser, String appUrl) {

		WebDriver driver=null;;
		
		if (browser.equalsIgnoreCase("Chrome")) 
		{
			System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Started");
			
		} else if (browser.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver","E:\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			System.out.println("IE Started");
		} 
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("Firefox Started");
		} else 
		
		{
			System.out.println("Sorry seems we dont support this driver/Browser..");
		}

		System.out.println("Test is getting executed by threads and threads id is "+Thread.currentThread().getId());
		System.out.println("Application is loading and URL is "+appUrl);
		driver.get(appUrl);
		System.out.println("Title is "+driver.getTitle());
		driver.quit();
	}

}
