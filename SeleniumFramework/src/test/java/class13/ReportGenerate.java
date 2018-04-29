package class13;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportGenerate {

	public static void main(String[] args) {
		
		
		ExtentReports report=new ExtentReports("./Reports/Index.html");
		
		ExtentTest logger=report.startTest("LoginTest");
		
		logger.log(LogStatus.PASS, "Login Done");

		report.endTest(logger);
		
		ExtentTest logger1=report.startTest("Logout");
		
		logger1.log(LogStatus.FAIL, "Logout Passed");

		logger1.log(LogStatus.FAIL,logger1.addScreenCapture("E:\\image.jpg"));
		
		report.endTest(logger1);
		
		ExtentTest logger2=report.startTest("CreateAccount");
		
		logger2.log(LogStatus.PASS, "Account Created");

		report.endTest(logger2);
		
		report.flush();
		
	}

}
