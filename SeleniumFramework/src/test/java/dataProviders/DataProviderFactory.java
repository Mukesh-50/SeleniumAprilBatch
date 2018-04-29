package dataProviders;

public class DataProviderFactory 
{
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		
		return excel;
	}
	
	
	
}
