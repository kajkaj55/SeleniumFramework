package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null ;
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName){
		System.out.println("Browser name is : " + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
			WebDriver driver  = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEdriver\\MicrosoftWebDriver.exe");
			WebDriver driver  = new InternetExplorerDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
			WebDriver driver  = new FirefoxDriver();
			
		}
	}
	
	@Test
	public void test1() throws InterruptedException{
		driver.get("https://automationstepbystep.com/");
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void teardown(){
		driver.close();
		System.out.println("Test completed Successfully");
		
	}
}
