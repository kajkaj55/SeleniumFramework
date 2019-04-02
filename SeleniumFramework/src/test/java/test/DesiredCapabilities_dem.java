package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_dem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
		
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEdriver\\MicrosoftWebDriver.exe");
		WebDriver driver  = new InternetExplorerDriver(caps);
		
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@title='Suche']")).sendKeys("ABC");
		driver.findElement(By.name("btnk")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();

	}

}
