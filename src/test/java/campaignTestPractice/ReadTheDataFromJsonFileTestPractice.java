package campaignTestPractice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTheDataFromJsonFileTestPractice {

	public static void main(String[] args) throws IOException, ParseException {
		
		
		//Step 1.Create a java representation of physical file
		
		FileReader fr = new FileReader("./resources/commondata.json");
		
		//Step 2. create the object of JSONparser and use parse method to pass the object of physical file
	     JSONParser jp = new JSONParser();
	     Object javaObject = jp.parse(fr);
	     
	     //Step 3. Convert java object to Json by Downcasting
	    JSONObject obj = (JSONObject)javaObject;
	    
	    //Step 4.Read data using get()
	   String BROWSER = obj.get("browser").toString();
	   String URL = obj.get("url").toString();
	   System.out.println(BROWSER);
	   System.out.println(URL);
	}

}
