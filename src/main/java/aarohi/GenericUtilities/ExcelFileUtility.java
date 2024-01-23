package aarohi.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	/**
	 * This Method will read the data from Excel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis= new FileInputStream(ConstantsUtility.excelFilePath);
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheet);
	Row rw = sh.getRow(row);
	Cell cel = rw.getCell(cell);
	String value= cel.getStringCellValue();
	wb.close();
	
	return value;
}
	

/**
 * This Method is for writing Data into Excel File
 * @param sheet
 * @param row
 * @param cell
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis= new FileInputStream(ConstantsUtility.excelFilePath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.createSheet(sheet);
	Row rw=sh.createRow(row);
	Cell cel=rw.createCell(cell);
	cel.setCellValue(sheet);
	
	FileOutputStream fos= new FileOutputStream(ConstantsUtility.excelFilePath);
	wb.write(fos);
	wb.close();
}


/**
 * This method read the data inside the sheet for data-provider
 * @param sheet
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMultipleDataFromExcel(String sheet, int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream(ConstantsUtility.excelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheet);
	int lastRow=sh.getLastRowNum();
	int lastCell= sh.getRow(0).getLastCellNum();
	
	Object[][] data= new Object[lastRow][lastCell];
	
	for(int i=0;i<lastRow;i++) {
		for(int j=0;j<lastCell;j++) {
	
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	
	return data;
	
}
	
}
