package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.reporters.jq.Main;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheeName){
		try {
		workbook = new XSSFWorkbook(excelPath); // (System.getProperty("user.dir")+"\\excel\\data.xlsx")
		sheet = workbook.getSheet(sheeName);	// ("Tabelle1")
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		
	}

	public static int getRowCount(){
		int rowCount=0;
	
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Number of rows : "+ rowCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
			return rowCount;
	}
	
	public static int getColCount(){
		int colCount = 0;
		try {
		colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of column : "+ colCount);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println(e.getCause());
		e.printStackTrace();
	}
		return colCount;
}
	
	public static String getCellDataString(int rowNum,int colNum){
		String cellData=null;
		try {
			
			cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	
	public static double getCellDataNumber(int rowNum,int colNum){
		double cellData =0.0;
		try {
			
			cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(cellData);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	
	
}
