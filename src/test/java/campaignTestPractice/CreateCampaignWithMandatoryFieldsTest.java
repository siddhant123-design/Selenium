package campaignTestPractice;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fileUtitlity.ExcelFileUtility;
import fileUtitlity.PropertyFileUtility;

public class CreateCampaignWithMandatoryFieldsTest {

	public static void main(String[] args) throws IOException {
		
		//Properties file
		//Step 1. Create the object of property file utility
		PropertyFileUtility pf = new PropertyFileUtility();
		
		//get the values
		String BROWSER = pf.toGetDataFromPropertiesFile("browser");
		String URL = pf.toGetDataFromPropertiesFile("url");
		String USERNAME = pf.toGetDataFromPropertiesFile("username");
	    String PASSWORD = pf.toGetDataFromPropertiesFile("password");
	    
	    
	    
	    
	    
	    //excel file
       //Step 1. create the object of excel file utility
	    ExcelFileUtility ex= new ExcelFileUtility();
       String campaignName = ex.toReadTheDataFromExcel("Camp",1,1);
       String targetSize = ex.toReadTheDataFromExcel("Camp", 1, 2);
	  
	    
	   
	    
		WebDriver driver = null;
		
		
		//launch the browser
	    if (BROWSER.equals("edge")) {
	    	 driver = new EdgeDriver();
		} else if (BROWSER.equals("chrome")) {
			 driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			 driver = new FirefoxDriver();
		}
		
		
		
		//Maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//Navigate to ninza CRM
		driver.get(URL);
		
		//Login into the ninza CRM
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Click on campaign link
		driver.findElement(By.linkText("Campaigns")).click();
		
		
	
		//Create campaign with Mandatory fields
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campaignName);
		WebElement targSize = driver.findElement(By.name("targetSize"));
		targSize.clear();
		targSize.sendKeys(targetSize);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//Verify the succesfull message
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(toastMsg));
		
		
	      String msg = toastMsg.getText();
	      
	      if (msg.contains("Avengers")) {
			System.out.println("Campign created successfully");
		} else {
            System.out.println("Campign is not created");
		}

	}

}
