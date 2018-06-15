package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {

	Properties pro;
	
	public configDataProvider()
	{
		
	try {
		
		File src = new File("./configuration/browser.properties");
		
		FileInputStream fis = new FileInputStream(src);
		
		pro = new Properties();
		
		pro.load(fis);
		
				
	} catch (Exception e) {
		
		System.out.println("Can't find  browser properties file");
	}
	
	}
	
	public String getTestURL()

	{
		return pro.getProperty("uaturl");
	
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String getValue(String key)
	{
		return pro.getProperty(key);
	}
	
}
