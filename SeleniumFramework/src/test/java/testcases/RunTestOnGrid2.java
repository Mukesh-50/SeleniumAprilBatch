package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import lib.Utility;

public class RunTestOnGrid2 {

	
	@Test
	public void test1() throws MalformedURLException
	{
		
		DesiredCapabilities caps=new DesiredCapabilities();
		
		caps.setCapability("browserName", "iPhone");
		 
		caps.setCapability("device", "iPhone 7");
		 
		caps.setCapability("realMobile", "true");
		
		caps.setCapability("os_version", "10.3");
		
		URL url=new URL("http://mukeshotwani3:s4GTbs4fFzQxJxzpzp2f@hub-cloud.browserstack.com/wd/hub");
		
		WebDriver driver=new RemoteWebDriver(url, caps);
		
		driver.get("https://www.seleniumhq.org/download/");
		
		System.out.println("Title is "+driver.getTitle());
		
		driver.quit();
		
	
	}
	
}
