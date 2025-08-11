package fileUtitlity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	public String toReadTheDataFromExcel(String sheet,int rowNum,int CellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fs = new FileInputStream("./resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		String data = wb.getSheet(sheet).getRow(rowNum).getCell(CellNum).getStringCellValue();
		wb.close();
		return data;
	}

}
