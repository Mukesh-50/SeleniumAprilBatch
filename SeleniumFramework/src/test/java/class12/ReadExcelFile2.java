package class12;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile2 
{

	@Test
	public void readFile() throws Exception
	{
		
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("./excelfile/TestData.xlsx")));
		
		String data1=wb.getSheet("UAT").getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(data1);
		
		System.out.println(wb.getSheet("Staging").getRow(0).getCell(0).getStringCellValue());
		
	}
	
	
}
