package class12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {

	@Test
	public void readFile() throws Exception {

		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(new File("./excelfile/TestData.xlsx")));

		String data1 = wb.getSheet("UAT").getRow(0).getCell(0).getStringCellValue();

		System.out.println(data1);

		System.out.println(wb.getSheet("Staging").getRow(0).getCell(0).getStringCellValue());

		wb.getSheet("Staging").getRow(0).createCell(2).setCellValue("PASS");

		wb.getSheet("Staging").createRow(1).createCell(0).setCellValue("Niya");

		wb.getSheet("Staging").getRow(1).createCell(1).setCellValue("Paul");

		FileOutputStream fout = new FileOutputStream(new File("./excelfile/TestData.xlsx"));

		wb.write(fout);

		fout.close();
	}

}
