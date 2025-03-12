package homepage_scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class O4_OpenRegisterpageFromHomepage {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://localhost:5173");
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		//find login link
		WebElement registerLink = driver.findElement(By.xpath("//a[@href='/register']"));
		registerLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualRegisterUrl = driver.getCurrentUrl();
		System.out.println(actualRegisterUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}
}