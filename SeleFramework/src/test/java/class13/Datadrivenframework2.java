package class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.BrowserFactory;
import lib.ExcelReader;

public class Datadrivenframework2 {
	
	@Test(dataProvider="myappData")
	public void loginOrangeHRM(String username,String password)
	{
	WebDriver driver = BrowserFactory.getBrowser("Chrome", "http://opensource.demo.orangehrmlive.com/");
	
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	driver.findElement(By.id("btnLogin")).click();
	
	BrowserFactory.closeBrowser(driver);
	
	}
	
	@DataProvider(name="myappData")
	public Object[][] passdata()
	{
		System.out.println("Data is getting ready");
					
		Object[][] arr = new Object[2][2];
		
		arr[0][0] = "admin";
		arr[0][1] = "admin";
		arr[1][0] = "Selenium";
		arr[1][1] = "webdriver";
				
		System.out.println("Data is  ready");
		
		return arr;
	}
	
}



