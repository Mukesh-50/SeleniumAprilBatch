package class13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.BrowserFactory;
import lib.ExcelReader;

public class DataDrivenFramework3 
{
	WebDriver driver;
	
	@BeforeMethod
	public void launchApp()
	{
		driver=BrowserFactory.getBrowser("Chrome", "http://opensource.demo.orangehrmlive.com/");
	}
	
	@AfterMethod
	public void closeApp()
	{
		BrowserFactory.closeBrowser(driver);
	}
	
	
	@Test(dataProvider="myappData")
	public void loginOrangeHRM(String username,String password)
	{
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	
	driver.findElement(By.id("btnLogin")).click();

	}
	
	
	@DataProvider(name="myappData")
	public Object[][] passData() 
	{
	
		System.out.println("Test Data is getting ready for the test");
		
		ExcelReader excel=new ExcelReader();
		
		int rows=excel.getNumberOfRows("UAT");
		
		Object[][] arr=new Object[rows][2];
	
		for(int i=0;i<rows;i++)
		{
			arr[i][0]=excel.getData(0, i, 0);
			arr[i][1]=excel.getData(0, i, 1);
		}
		System.out.println("Test Data is ready and start the test");
		
		return arr;
		
	}

}
