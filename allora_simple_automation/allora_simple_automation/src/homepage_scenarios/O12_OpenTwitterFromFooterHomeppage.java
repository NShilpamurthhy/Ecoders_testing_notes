
package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O12_OpenTwitterFromFooterHomeppage {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173");
	
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		//find login link
		WebElement footerTwitterLink = driver.findElement(By.xpath("//a[@href='https://twitter.com']"));
		footerTwitterLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(2000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		String actualfooterTwitterLinkUrl = driver.getCurrentUrl();
		System.out.println(actualfooterTwitterLinkUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(1000);
		driver.quit();
		

	}

}
