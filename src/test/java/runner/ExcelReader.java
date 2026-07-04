package runner;

import utils.ExcelUtils;

public class ExcelReader {
	public static void main(String[] args) {
		//String filePath1 = System.getProperty("user.dir")+ "\\src\\test\\resources\\testData.xlsx";
		String filePath = "D:\\Selenium\\DataDrivenFramework\\src\\test\\resources\\testData.xlsx";
		
		ExcelUtils xlsReader = new ExcelUtils(filePath);
		
		//xlsReader.getRowCount("CompanyData");
		
		//System.out.println(xlsReader.getColumnCount("CompanyData"));
		
		String sheetName = "CompanyData";
		//String dataFlag = "";
		
		int colNumber = 0;
		
		while(!xlsReader.getCellData(sheetName, colNumber, 0).equals("")) {
			
		}
	}
}
