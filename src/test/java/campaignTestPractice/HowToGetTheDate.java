package campaignTestPractice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HowToGetTheDate {

	public static void main(String[] args) {
		
		//Create the object of date to get the todays date
		Date date = new Date();//import from java.util package
		
		//Format Date 
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		
		cal.add(Calendar.DAY_OF_MONTH, 30);
		System.out.println(sim.format(cal.getTime()));
	

	}

}
