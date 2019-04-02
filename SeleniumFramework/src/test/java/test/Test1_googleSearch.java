package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test1_googleSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		googleSearch();

	}
	
	public static void googleSearch() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
	
		//go to google.com
		driver.get("https://www.google.com/");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("kadjdahi");
		
		
		//click on search Button
		/**driver.findElement(By.name("btnK")).click();*/
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//close the Browser
		driver.close();
		
		//end Test
		System.out.println("Test Completed Successfully");

	}

}
