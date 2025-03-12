
package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O14_OpenAddressTextFromFooterHomepage {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173");
	
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		

		 JavascriptExecutor js = (JavascriptExecutor) driver;
	      
		      WebElement AddressSection = driver.findElement(By.xpath("(//a)[21]"));
		      
		          Thread.sleep(1000);
		          js.executeScript("arguments[0].scrollIntoView(true)",    AddressSection );
		          Thread.sleep(1000); 

		          for(int i = 21; i<= 24; i++)
		          {
		        	 
		        	 String AddressSectionTexts =  driver.findElement(By.xpath("(//a)["+i+"]")).getText();
		        	 System.out.println( AddressSectionTexts);
		        	 
		        	 //System.out.println("\n*******************************************************\n");
		        	 Thread.sleep(500);
		          }
		      driver.quit();
	}

}
