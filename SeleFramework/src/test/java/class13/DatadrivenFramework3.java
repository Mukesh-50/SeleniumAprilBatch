package class13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lib.BrowserFactory;
import lib.ExcelReader;

public class DatadrivenFramework3 {
	
	WebDriver driver;
	ArrayList<String> x;
	XSSFWorkbook wb;
	
    @BeforeMethod
	public void launchapp()
	{
	  driver = BrowserFactory.getBrowser("Chrome", "http://opensource.demo.orangehrmlive.com/");
	}
    
    @AfterMethod
    public void closeapp() throws Exception
    {
    	
        ExcelReader excel1 = new ExcelReader();
		
		int rows = excel1.getNumberOfRows("UAT");
		
		Object[][] arr = new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			ArrayList<String> s = x;
			System.out.println(s);
		    wb.getSheet("UAT").getRow(i).createCell(2).setCellValue("s");
		    
		}
        FileOutputStream fos = new FileOutputStream(new File("./ExcelFile/testdata.xlsx"));
		
		wb.write(fos);
		
		fos.close();
		
		
    	BrowserFactory.closeBrowser(driver);
    }

	@Test(dataProvider="myappData")
	public void loginOrangeHRM(String username,String password) throws Exception
	{
	ArrayList<String> x = new ArrayList();
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.id("txtPassword")).sendKeys(password);
	driver.findElement(By.id("btnLogin")).click();
	Thread.sleep(1000);
	System.out.println(driver.getCurrentUrl());
	if((driver.getCurrentUrl()).contains("dashboard"))
	{
		x.add("Pass");
	}
	else
	{
		x.add("Fail");
	}
	}
	
	@DataProvider(name="myappData")
	public Object[][] passdata()
	{
		System.out.println("Data is getting ready");
					
		ExcelReader excel = new ExcelReader();
		
		int rows = excel.getNumberOfRows("UAT");
		
		Object[][] arr = new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			arr[i][0] = excel.getData(0, i, 0);
			arr[i][1] = excel.getData(0, i, 1);
		}
		
		System.out.println("Data is  ready");
		
		return arr;
	}
}
