package class12;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelFile3 
{

	@Test
	public void readFile() throws Exception
	{
		
		XSSFWorkbook wb=new XSSFWorkbook(new FileInputStream(new File("./excelfile/TestData.xlsx")));
		
		System.out.println("Rows "+wb.getSheet("Prod").getPhysicalNumberOfRows());
		
		int row=wb.getSheet("Prod").getPhysicalNumberOfRows();
		
		for(int i=0;i<row;i++)
		{
			System.out.println(wb.getSheetAt(2).getRow(i).getCell(0).getStringCellValue());
			System.out.println(wb.getSheetAt(2).getRow(i).getCell(1).getStringCellValue());
		}
		
	}
	
	
}
