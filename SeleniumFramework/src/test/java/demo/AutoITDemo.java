package demo;

	import java.util.regex.Pattern;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

	public class AutoITDemo {
		
		public static void test() throws IOException, InterruptedException{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
		WebDriver driver  = new FirefoxDriver();
			
		
	    driver.get("http://www.tinyupload.com/");
	    driver.findElement(By.name("uploaded_file")).click();
	    
	   // Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\autoitExe\\FileUploadSript.exe");
	    
	    Thread.sleep(7000);
	    driver.close();
	    
	 
	}
		
		public static void main(String[] args) throws IOException, InterruptedException {
			test();
		}


	}
