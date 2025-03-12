
package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O15_CopyrightTextFromfooterHomepage {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173");
	
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		//find login link
		String footerCopyrightText = driver.findElement(By.xpath("//p[text()='copyright © → ecoders Bangalore']")).getText();
		System.out.println(footerCopyrightText);
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.quit();
		

	}

}
