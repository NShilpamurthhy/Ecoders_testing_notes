package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O5_OpenLogoutpageFromHomepage {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173");
	
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
//		WebElement registerLink = driver.findElement(By.xpath("//a[@href='/register']"));
//		registerLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//find login link
		WebElement LogoutLink = driver.findElement(By.xpath("//a[@href='/home']"));
		LogoutLink.click();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualLogoutUrl = driver.getCurrentUrl();
		System.out.println(actualLogoutUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		driver.quit();
		

	}

}
