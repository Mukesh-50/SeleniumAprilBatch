package class12;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcel2 {

	@Test
	public void readfile() throws Exception
	{
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("./ExcelFile/testdata.xlsx")));
		
		String data1 = wb.getSheet("UAT").getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(data1);
		
		System.out.println(wb.getSheet("Staging").getRow(0).getCell(1).getStringCellValue());
	}
}
