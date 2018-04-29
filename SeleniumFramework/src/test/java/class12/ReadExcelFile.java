package class12;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile 
{

	@Test
	public void readFile() throws Exception
	{
		
		File src=new File("./excelfile/TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh1=wb.getSheet("UAT");
		
		XSSFRow r1=sh1.getRow(1);
		
		XSSFCell c1=r1.getCell(0);
		
		String data1=c1.getStringCellValue();
		
		System.out.println(data1);
		
		
	}
	
	
}
