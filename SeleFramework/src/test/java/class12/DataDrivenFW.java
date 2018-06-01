package class12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenFW {
	
	@Test(dataProvider="testdata")
	public void testChrome(String uname,String password)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\mural\\chromedriver\\chromedriver2.37.exe");;
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.facebook.com");
		
		driver.findElement(By.id("email")).clear();
		
		driver.findElement(By.id("email")).sendKeys(uname);
	    
		driver.findElement(By.id("pass")).clear();
		
		driver.findElement(By.id("pass")).sendKeys(password);
		
	}
	@DataProvider(name="testdata")
	public Object[][] Testdatafeed()
	{
		Object [][] facebookdata = new Object[2][2];
		
		facebookdata[0][0] = "selenium1@gmail.com";
		facebookdata[0][1] = "password1";
		facebookdata[1][0] = "selenium2@gmail.com";
		facebookdata[1][1] = "password2";
		return facebookdata;
	}

}
