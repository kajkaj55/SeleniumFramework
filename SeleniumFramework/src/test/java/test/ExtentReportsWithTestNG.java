package test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelUtils;
import utils.ExcelDataProvider;

public class ExtentReportsWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
        htmlReporter = new ExtentHtmlReporter("extent3.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
	}
        
	@BeforeTest
	private void publi() {
		// Start the WebDriver
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
		driver  = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	
	@DataProvider(name = "test1data")
	public Object [][] getData(){
		Object data[][] = ExcelDataProvider.testData(System.getProperty("user.dir")+"\\excel\\data.xlsx","Tabelle1");
		return data;
		
	}
	
	
	@Test(dataProvider="test1data")
	public void webSeiteTesten(String userName,String passWord) throws IOException, InterruptedException{
		// creates a toggle for the given test, adds all log events under it 
		ExtentTest test = extent.createTest("Google Search Test One", "This is Test to validate google funtionality");
		
		 // log(Status, details)
        test.log(Status.INFO, "Starting Test Case");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		test.pass("Navigated to opensource-demo.orangehrmlive.com");
		
		driver.findElement(By.id("txtUsername")).sendKeys(userName);
		test.pass("Entered the Username");
		
		driver.findElement(By.id("txtPassword")).sendKeys(passWord);
		test.pass("Entered the Password");
		
		driver.findElement(By.id("btnLogin")).click();
		test.pass("Pressed the Login button");
		Thread.sleep(5000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.id("welcome")));
		//driver.findElement(By.className("panelTrigger")).click();
		//driver.findElement(By.id("welcome")).click();
		test.pass("Pressed the Wecomlist link");
		
		
		driver.findElement(By.linkText("Logout")).click();
		test.pass("Pressed the Logout button");
        
		
		// log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        // info(details)
        test.info("This step shows usage of info(details)");
        // log with snapshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
	}
	
	@AfterTest
	public void tearDownTest(){
		driver.close();
		//driver.quit();
		System.out.println("Test Completed Successfully");
	}
	
	@AfterSuite
	public void tearDown(){
		// calling flush writes everything to the log file
        extent.flush();
	
	}
}
