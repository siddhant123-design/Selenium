package campaignTestPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileUtitlity.ExcelFileUtility;

public class MutilpleSetOfDataUsingDataProvider {
	
	
	@DataProvider
	public Object[][] loginDetails() throws EncryptedDocumentException, IOException {
		
		ExcelFileUtility ex = new ExcelFileUtility();
		int lastRow = ex.toGetTheRowCount("Campaigns");
		
		Object[][] obj = new Object[lastRow][2];
		
		for (int i = 0; i < lastRow; i++) {
			
			obj[i][0]=ex.toReadTheDataFromExcel("Campaigns", i+1, 1);
			obj[i][1]=ex.toReadTheDataFromExcel("Campaigns",i+1, 2);
		}
		
	return obj;
	}
	
	@Test(dataProvider = "loginDetails")
	public void login(String un,String pwd) {
		System.out.println(un+"======"+pwd);
	}

}
