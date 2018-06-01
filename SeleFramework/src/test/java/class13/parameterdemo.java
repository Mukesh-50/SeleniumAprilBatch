package class13;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameterdemo {
	
	@Parameters({"Browser","URL"})
	@Test
	public void passparameters(String Browser,String appurl)
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.out.println("Chrome started");
		} else if(Browser.equalsIgnoreCase("IE"))
		{
			System.out.println("IE started");
		} else if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.out.println("FireFox started");
		} else
		{
			System.out.println("Sorry this browser is not supported");
		}
		
		System.out.println("Application is loading"+appurl);
			
	}

}
