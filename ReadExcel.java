package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readData(String sheetName) throws IOException
	{
		XSSFWorkbook wb= new XSSFWorkbook("./data/LeadData.xlsx");
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowSize = sheet.getLastRowNum();
		short colSize = sheet.getRow(0).getLastCellNum();
		System.out.println(rowSize);
		System.out.println(colSize);
		String data[][]= new String[rowSize][colSize];
		
		for(int i=1;i<=rowSize;i++)
		{
			for(int j=0;j<colSize;j++)
			{
			 data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			 System.out.println(data);
			}
		}
		wb.close();
		return data;
	}

}
