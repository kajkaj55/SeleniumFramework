package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportTest {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		 // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "This is Test to validate google funtionality");
        
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
		driver  = new FirefoxDriver();
		
		 // log(Status, details)
        test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://www.google.com/");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("A B C");
		test1.pass("Entered text in Searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed keyboard enter Key");
		
		driver.close();
		driver.quit();
		test1.pass("Close the Browser");
		
		test1.info("Test Completed");
		
		// calling flush writes everything to the log file
        extent.flush();

   
	}

}
