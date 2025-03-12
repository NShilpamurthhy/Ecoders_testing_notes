package homepage_scenarios;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class O1_OpenContactpageFromHomepage {
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		driver=new ChromeDriver();
		 System.out.println("Chrome browser opened successfully.");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 
		 driver.get("http://localhost:5173/");
		 
		
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//find contact link
		 WebElement contactLink = driver.findElement(By.xpath("(//a[text()='Contact'])[1]"));
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 contactLink.click();
		 
		String actualcontactUrl = driver.getCurrentUrl();
		System.out.println("Actual url is "+ actualcontactUrl);
		String expectedcontactUrl = "http://localhost:5173/contact-us";
		System.out.println(" Expeced url is " + expectedcontactUrl);
		
		if(expectedcontactUrl.equals(actualcontactUrl))
		{
			// take the screen shot. 
			TakesScreenshot ts   = (TakesScreenshot)driver; 
	    	File ramlocation = ts.getScreenshotAs(OutputType.FILE);
	    	File hardDiskLocation =new File(System.getProperty("user.dir")+"/screenshotFolder/" + "contact_page_image.jpg");
	    	Files.copy(ramlocation, hardDiskLocation);
	    	System.out.println("Screen shot saved.");
	    	System.out.println("Tc failed.");
		}
		else
		{
			System.out.println("Test case passed.");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}
}
