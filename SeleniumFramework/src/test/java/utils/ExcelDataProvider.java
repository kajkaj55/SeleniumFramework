package utils;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	public static Object [][] testData(String excelPath, String sheetName){
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		
		int rowCount = excel.getRowCount();
		int cellCount = excel.getColCount();
		
		Object data[][] = new Object [rowCount-1][cellCount];
		
		for(int i=1; i<rowCount ; i++){
			for(int j=0 ;j<cellCount ; j++){
				
				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | ");
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;
			
	}
	
	/*@DataProvider(name = "test1data")
	public Object [][] getData(){
		Object data[][] = testData(System.getProperty("user.dir")+"\\excel\\data.xlsx","Tabelle1");
		return data;
		
	}*/

	

}
