package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelUtils {

	public XSSFWorkbook workbook = null;
	public FileInputStream fis = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public ExcelUtils(String filePath) {
		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Get row data
	// Get column data

	// Get total columns
	public int getColumnCount(String sheetName) {
		int sheetIndex = workbook.getSheetIndex(sheetName);
		if (sheetIndex == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(sheetIndex);
			row = sheet.getRow(0);
			return row.getLastCellNum();
		}
	}

	// Get Row count
	public int getRowCount(String sheetName) {
		int sheetIndex = workbook.getSheetIndex(sheetName);
		if (sheetIndex == -1) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(sheetIndex);
			return sheet.getLastRowNum() + 1;
		}
	}

	// Get cell data with column name
	public String getCellData(String sheetName, String colName, int rowNum) {
		int sheetIndex = workbook.getSheetIndex(sheetName);

		// Check whether the sheet is valid or not
		if (sheetIndex == -1) {
			return "";
		}
		
		if (rowNum <= 0) {
			return "";
		}

		sheet = workbook.getSheetAt(sheetIndex);
		row = sheet.getRow(0);
		int colNum = -1;

		for (int i = 0; i < row.getLastCellNum(); i++) {
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				colNum = i;
			}
		}

		// Check whether the column is not available
		if (colNum == -1) {
			return "";
		}

		// Check whether the row is not available
		row = sheet.getRow(rowNum - 1);
		if (row == null) {
			return "";
		}

		cell = row.getCell(colNum);

		// Check the cell is valid or not
		if (cell == null) {
			return "";
		}

		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
			String cellText = String.valueOf(cell.getNumericCellValue());
			return cellText;
		} else if (cell.getCellType() == CellType.BLANK) {
			return "";
		} else {
			return String.valueOf(cell.getBooleanCellValue());
		}
	}
	
	// Get cell data with column number
		public String getCellData(String sheetName, int colNum, int rowNum) {
			int sheetIndex = workbook.getSheetIndex(sheetName);

			// Check whether the sheet is valid or not
			if (sheetIndex == -1) {
				return "";
			}
			
			if (rowNum <= 0) {
				return "";
			}
			
			if (colNum < 0) {
				return "";
			}

			sheet = workbook.getSheetAt(sheetIndex);
			row = sheet.getRow(0);
			

			// Check whether the row is not available
			row = sheet.getRow(rowNum - 1);
			if (row == null) {
				return "";
			}

			cell = row.getCell(colNum);

			// Check the cell is valid or not
			if (cell == null) {
				return "";
			}

			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == CellType.BLANK) {
				return "";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		}

}
