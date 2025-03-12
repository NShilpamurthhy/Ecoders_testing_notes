package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class O10_OpenHomepageUrl {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("http://localhost:5173");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		String actualhomepageUrl = driver.getCurrentUrl();
		System.out.println(actualhomepageUrl);
		
		driver.quit();
		
	}

}
