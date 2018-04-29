package lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory 
{

	static WebDriver driver;
	
	public static WebDriver getBrowser(String browser,String appUrl)
	{
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
		
		return driver;

	}
	
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
		System.out.println("Browser Closed");
	}
	
	
}
