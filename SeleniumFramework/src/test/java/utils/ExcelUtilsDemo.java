package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		ExcelUtils excel = new ExcelUtils(System.getProperty("user.dir")+"\\excel\\data.xlsx", "Tabelle1");
		
		excel.getCellDataNumber(2, 1);
		excel.getCellDataString(0, 0);
		excel.getRowCount();

	}

}
