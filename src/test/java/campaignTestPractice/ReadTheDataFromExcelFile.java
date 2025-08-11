package campaignTestPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadTheDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		 //excel file
	    //Step 1-Create java representation object of physical file
		FileInputStream fs = new FileInputStream("./resources/testdata.xlsx");
		
		//Step 2-Open excel in read mode
	   Workbook wb = WorkbookFactory.create(fs);
	   
	   //Step 3 - get the control of sheet
	   Sheet sheet = wb.getSheet("Campaigns");
	   
	   //Step 4 - get the control of Row
	   Row rw = sheet.getRow(1);
	   
	   //Step 5 - get the control of cell
	   Cell cl = rw.getCell(1);
	   
	   //Step 6 - Read the data from cell
	   String campaignName = cl.getStringCellValue();
	   
	   System.out.println(campaignName);
	   
	   
	  String targSize = sheet.getRow(1).getCell(2).getStringCellValue();
	  
	  System.out.println(targSize);
	  
	   

	}

}
