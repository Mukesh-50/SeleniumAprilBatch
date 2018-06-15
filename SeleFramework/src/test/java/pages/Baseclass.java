package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProviders.DataproviderFactory;
import lib.BrowserFactory;
import lib.Utility;

public class Baseclass {
	
	public WebDriver driver;
	public ExtentReports report;  
	public ExtentTest logger;
	
	@BeforeSuite
	public void startTestSuite()
	{
	 System.out.println("**********************");
	 System.out.println("Test Started");
	 report = new ExtentReports(System.getProperty("user.dir") + "/Reports/"+ Utility.getCurrentDateTime() +".html");
	}
	
	@BeforeClass
	public void startTest()
	{
      driver = BrowserFactory.getBrowser(DataproviderFactory.getConfig().getBrowser(), DataproviderFactory.getConfig().getTestURL());
	}
	
	@AfterClass
	public void endTest()
	{
		//BrowserFactory.closeBrowser(driver);
		driver.quit();
	}
	
	@AfterMethod
	public void endLogger(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path = Utility.captureScreenshot(driver);
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
			logger.log(LogStatus.FAIL, result.getThrowable().getMessage());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "Test completed Successfully");
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
		 System.out.println("Test Ended");
		 report.flush();
		 System.out.println("**********************");
	}

	
}
