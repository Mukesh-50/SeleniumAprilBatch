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

public class RunTestOnGrid {

	
	@Test
	public void test1() throws MalformedURLException
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		cap.setBrowserName(BrowserType.CHROME);
		
		
		URL url=new URL("http://192.168.1.3:4444/wd/hub");
		
		WebDriver driver=new RemoteWebDriver(url, cap);
		
		driver.get("https://www.seleniumhq.org/download/");
		
		Utility.sleep(20);
		
		System.out.println("Title is "+driver.getTitle());
		
		Utility.sleep(20);
		
		driver.quit();
		
	
	}
	
}
