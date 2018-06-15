package lib;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {
	// This will wit for WebElement
	public static void syncWebElement(WebDriver driver,WebElement element,int time)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// This will highlight the WebElement
	public static void highlightWebElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",element);
		
		try {
			
			Thread.sleep(500);
			
		} catch (InterruptedException e) {
			
			System.out.println(e.getMessage());
		}
	
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid white');",element);
	}
	
	// final lib for wait and highlighting WebElement
	public static WebElement waitforWebElement(WebDriver driver,WebElement element,int time)
	{
		syncWebElement(driver,element,time);
		highlightWebElement(driver,element);
		return element;
	}
	
	public static String captureScreenshot(WebDriver driver)
	{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir") + "/Screenshots/"+System.currentTimeMillis()+".png";
					
			try {
				
				FileUtils.copyFile(src,new File(dest));
				
			} catch (IOException e) {
				
				System.out.println("Not able to capture Screenshot "+e.getMessage());
			}
			
			return dest;
		}
	
	public static String getCurrentDateTime()
	{
		
		DateFormat dateformat = new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		
		Date date = new Date();
		
		String currentDate = dateformat.format(date);
		
		return currentDate;
	 }
	
	public static void waitforTitle(WebDriver driver,String title,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		
		wait.until(ExpectedConditions.titleContains(title));
		
	    Assert.assertTrue(driver.getTitle().contains(title));
				
	}
	
	public static void waitforURLContains(WebDriver driver,String urlContains,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		
		wait.until(ExpectedConditions.urlContains(urlContains));
		
	    Assert.assertTrue(driver.getCurrentUrl().contains(urlContains));
				
	}
	
	
	public static void waitforAlertAndAccept(WebDriver driver,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		
		alt.accept();
	    				
	}
	
	public static void waitforAlertAndDismiss(WebDriver driver,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		
		alt.dismiss();
	    				
	}
	
	public static String waitforAlertAndgeText(WebDriver driver,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		
		Alert alt = wait.until(ExpectedConditions.alertIsPresent());
		
		return alt.getText();
	    				
	}
	
	public static void frameSwitchUsingNameorId(WebDriver driver, String NameorId,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(NameorId));
		
	}
	
	public static void frameSwitchUsingIndex(WebDriver driver, int indexNumber,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(indexNumber));
		
	}
	
	public static void frameSwitchUsingWebElement(WebDriver driver,WebElement frame,int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
	}
	
	public static void sleep(int seconds)
	{
		try {
			
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) {
			
		}
	}
	
}


