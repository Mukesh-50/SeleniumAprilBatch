package class13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowsertest {

	@Parameters({"Browser","URL"})
	@Test
	public void passparameters(String Browser,String appurl)
	{
		WebDriver driver=null;
		if(Browser.equalsIgnoreCase("Chrome"))
		{
				
			System.setProperty("webdriver.chrome.driver","C:\\Users\\mural\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome started");
			
			
		} else if(Browser.equalsIgnoreCase("IE"))
		{
			
			System.setProperty("webdriver.ie.driver","C:\\Users\\mural\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("IE started");
			
		} else if(Browser.equalsIgnoreCase("Firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\mural\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("FireFox started");
			
		} else
		{
			System.out.println("Sorry this browser is not supported");
		}
		

		System.out.println("Tests are executed by threads thread id is"+Thread.currentThread().getId());
		
		System.out.println("Application is loading"+appurl);
	
		driver.get(appurl);
		
		System.out.println(driver.getTitle());
		
		//driver.quit();
	}

}
