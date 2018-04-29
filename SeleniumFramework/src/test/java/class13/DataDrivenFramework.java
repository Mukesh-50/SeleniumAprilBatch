package class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.BrowserFactory;

public class DataDrivenFramework 
{

	
	@Test(dataProvider="myappData")
	public void loginOrangeHRM(String username,String password)
	{
		
	WebDriver driver=BrowserFactory.getBrowser("Chrome", "http://opensource.demo.orangehrmlive.com/");
	
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	
	driver.findElement(By.id("btnLogin")).click();
	
	BrowserFactory.closeBrowser(driver);
	
	}
	
	@DataProvider(name="myappData")
	public Object[][] passData() 
	{
	
		System.out.println("Test Data is getting ready for the test");
		
		Object[][] arr=new Object[4][2];
		arr[0][0]="admin";
		arr[0][1]="admin";
		arr[1][0]="selenium";
		arr[1][1]="webdriver";
		
		arr[2][0]="selenium1";
		arr[2][1]="webdriver1";
		arr[3][0]="selenium2";
		arr[3][1]="webdriver2";
		System.out.println("Test Data is ready and start the test");
		
		return arr;
		
	}

}
