package class12;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadConfig {
	@Test
	public void readFile() throws IOException 
	{
		File src=new File("./configuration/browser.properties");
		
		FileInputStream fis = new FileInputStream(src);
		
		Properties pro = new Properties();
		
		pro.load(fis);
		
		String url = pro.getProperty("uaturl");
		System.out.println(url);
		System.out.println(pro.getProperty("browser"));
	//	System.out.println(pro.getProperty("trainer"));
	}

}
