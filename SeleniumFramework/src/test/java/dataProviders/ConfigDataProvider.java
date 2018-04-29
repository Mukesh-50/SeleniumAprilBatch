package dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		try 
		{
			File src = new File("./configuration/browser.properties");

		
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();

			pro.load(fis);
			
		} catch (Exception e) 
		{
			System.out.println("Failed to load config file");
		}

	}
	
	public String getTestURL()
	{
		return pro.getProperty("stagingurl");
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
