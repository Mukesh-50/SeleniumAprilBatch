package class13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersDemo {

	@Parameters({ "Browser", "URL" })
	@Test
	public void testParameters(String browser, String appUrl) {

		if (browser.equalsIgnoreCase("Chrome")) 
		{
			System.out.println("Chrome Started");
			
		} else if (browser.equalsIgnoreCase("IE")) 
		{
			System.out.println("IE Started");
		} 
		else if (browser.equalsIgnoreCase("Firefox")) 
		{
			System.out.println("Firefox Started");
		} else 
		
		{
			System.out.println("Sorry seems we dont support this driver/Browser..");
		}

		System.out.println("Application is loading and URL is "+appUrl);
	}

}
