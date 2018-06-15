package dataProviders;

public class DataproviderFactory {
	
	public static configDataProvider getConfig()
	{
		configDataProvider config = new configDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
	
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
		
	}

}
