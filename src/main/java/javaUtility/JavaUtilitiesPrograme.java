package javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilitiesPrograme {

	public int getRandowmNumber(){
		Random rd = new Random();
		int randomNumber = rd.nextInt(1000);
		return randomNumber;
	}
	
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = sim.format(date);
		return currentDate;
	}
	
	public String getRequireDate(int exDate) {
		//Create the object of date to get the todays date
				Date date = new Date();//import from java.util package
				
				//Format Date 
				SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
				sim.format(date);
				Calendar cal = sim.getCalendar();
				
				cal.add(Calendar.DAY_OF_MONTH, exDate);
				String expectedDate = sim.format(cal.getTime());
				return expectedDate;
	}
	
}
