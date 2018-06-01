package class12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {

	@Test
	public void readfile() throws Exception
	{
		
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("./ExcelFile/testdata.xlsx")));
		
		String data1 = wb.getSheet("UAT").getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(data1);
		
		System.out.println(wb.getSheet("Staging").getRow(0).getCell(1).getStringCellValue());
		
		int row = wb.getSheetAt(2).getPhysicalNumberOfRows();
		
		System.out.println(row);
		
		
		
		for(int i=0; i<row; i++)
		{
		
			System.out.println(wb.getSheet("Prod").getRow(i).getCell(0).getStringCellValue());
			System.out.println(wb.getSheet("Prod").getRow(i).getCell(1).getStringCellValue());
			wb.getSheet("Prod").getRow(i).createCell(2).setCellValue("Pass");
			
		}
		
		
	
		wb.getSheet("Staging").createRow(1).createCell(0).setCellValue("Selenium");
		
		
		FileOutputStream fos = new FileOutputStream(new File("./ExcelFile/testdata1.xlsx"));
		
		wb.write(fos);
		
		fos.close();
		
    }
	
}
	
