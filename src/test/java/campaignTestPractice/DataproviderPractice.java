package campaignTestPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderPractice {
	
	
	@DataProvider
	public Object[][] loginDetails() {
		Object[][] obj = new Object[3][2];	
		
		obj[0][0]="pratiksha";
		obj[0][1]="prati@123";
		obj[1][0]="sangeeta";
		obj[1][1]="sangu@123";
	    obj[2][0]="ankit";
	    obj[2][1]="anku@123";
	    
	    return obj;
	}
	
	@Test(dataProvider = "loginDetails")
	public void login(String un,String pwd) {
		System.out.println(un+"============="+pwd);
	}
	


}
