

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


// https://github.com/bonigarcia/webdrivermanager

public class BrowserTest {

	public static void main(String[] args) {
		
		/**System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver  = new ChromeDriver();*/
		
		/**System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEdriver\\MicrosoftWebDriver.exe");
		WebDriver driver  = new InternetExplorerDriver();*/
		
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver\\geckodriver.exe");
		//WebDriver driver  = new FirefoxDriver();
		
		
		/**___________________________________________________________________________________*/
		// man kann das driver durch den webdrivermanager starten
		
		//WebDriverManager.chromedriver().version("71.0.3578.33").setup();
		//WebDriver driver  = new ChromeDriver();
		//WebDriverManager.iedriver().setup();
		//WebDriver driver  = new InternetExplorerDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver  = new FirefoxDriver();
		
		//driver.get("http://blazedemo.com/");
		
		//WebElement el1 = driver.findElement(By.xpath("//option[@value='San Diego']"));
		//WebElement el2 = driver.findElement(By.xpath("//option[@value='New York']"));
		//WebElement el3 = driver.findElement(By.className("btn btn-primary"));
		//el3.click();
		
		/** --------------- ein zwetes beispiel ----------------------------------*/
		
		driver.get("https://www.google.com/");
		//WebElement textBox = driver.findElement(By.name("q"));
		WebElement textBox = driver.findElement(By.xpath("//input[@title='Suche']"));
		textBox.sendKeys("kadjdahi");
		
		//driver.findElement(By.xpath("//input[@title='Suche']")).sendKeys("kadjdahi");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		

	}

}
