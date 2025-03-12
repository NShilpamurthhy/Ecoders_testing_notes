package homepage_scenarios;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class O2_OpenAboutpageFromHomepage {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173/");
		
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		//find about link
		
		driver.findElement(By.xpath("//a[text()='About']"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		String actualAboutUrl = driver.getCurrentUrl();
		System.out.println(actualAboutUrl);
		Thread.sleep(1000);
		driver.quit();
		
		
	}

}
