package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProviders.DataProviderFactory;
import lib.BrowserFactory;
import lib.Utility;

public class BaseClass 
{

	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupTestSuite()
	{
			System.out.println("********************************************");
			System.out.println("Test Suite Start");
			report=new ExtentReports(System.getProperty("user.dir")+"/Reports/"+Utility.getCurrentDateTime()+".html");
			
	}
	
/*	@BeforeClass
	public void startTest()
	{
		driver=BrowserFactory.getBrowser(DataProviderFactory.getConfig().getBrowser(),DataProviderFactory.getConfig().getTestURL());
	}
	*/
	
	@Parameters({"Browser","url"})
	@BeforeClass
	public void startTest(String browser,String url)
	{
		driver=BrowserFactory.getBrowser(browser,url);
	}
	
	@AfterClass
	public void endTest()
	{
		//driver.quit();
	}
	
	@AfterMethod
	public void endLogger(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Utility.captureScreenshot(driver);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			logger.log(LogStatus.FAIL, "Test Failed because of "+result.getThrowable().getMessage());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "Test Completed Successfully");
		}
		else
		{
			logger.log(LogStatus.SKIP, "Test Skipped "+result.getThrowable().getMessage());
		}
		report.endTest(logger);	
	}
	
	
	
	@AfterSuite
	public void tearDownTestSuite()
	{
		System.out.println("Test Suite End");
		report.flush();
		System.out.println("********************************************");
	
	}
	
}
