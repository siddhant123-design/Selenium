package campaignTestPractice;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleSetOFDataFromExcelTestPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		
		FileInputStream fs = new FileInputStream("./resources/testdata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		
		int lastRowNum = wb.getSheet("Campaigns").getLastRowNum();
		
		System.out.println(lastRowNum);
		
		
		for (int i = 1; i <=lastRowNum; i++) {
		String campName = wb.getSheet("Campaigns").getRow(i).getCell(1).getStringCellValue();
		System.out.println(campName);
		}
	}

}
