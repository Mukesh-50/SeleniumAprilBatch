package class12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadConfigFile2 
{

	@Test
	public void readFile() throws IOException
	{
		
		Properties pro=new Properties();
		
		pro.load(new FileInputStream(new File("./configuration/browser.properties")));
		
		String url=pro.getProperty("uaturl");
		
		System.out.println(url);
		
		System.out.println(pro.getProperty("browser"));
		
		System.out.println(pro.getProperty("trainer"));
		
	}
	
}
