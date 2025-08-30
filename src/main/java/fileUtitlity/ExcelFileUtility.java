package fileUtitlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public int toGetTheRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fs = new FileInputStream("./resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		int lastRowNum = wb.getSheet(sheet).getLastRowNum();
		return lastRowNum;
	}
	
	public List<String> toReadMultiSetOfData(int lastRowNum,String sheet,int CellNum) throws EncryptedDocumentException, IOException{
		List<String> ls = new ArrayList<String>();
		FileInputStream fs = new FileInputStream("./resources/testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fs);
		
		for (int i = 1; i <=lastRowNum  ; i++) {
			String data= wb.getSheet(sheet).getRow(i).getCell(CellNum).getStringCellValue();
			ls.add(data);
		}
		return ls;
	}

}
