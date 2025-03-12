package homepage_scenarios;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O3_OpenLoginpageFromHomepage {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173");
	
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		//find login link
		WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
		loginLink.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualLoginUrl = driver.getCurrentUrl();
		System.out.println(actualLoginUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
		

	}

}
