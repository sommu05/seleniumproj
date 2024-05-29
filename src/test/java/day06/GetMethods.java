package day06;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//get(url)
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
 
		//getTitle()
		System.out.println(driver.getTitle());
		
		//getCurrentURL()
		System.out.println(driver.getCurrentUrl());
		
		//getPagesource()
		//Need to chack if pagesource conatains html word, we can achieve this by contains method 
		String ps= driver.getPageSource();
		
		System.out.println(ps.contains("html"));
		//System.out.println(ps);
		
		//getWindowHandle()
		System.out.println("Window Id is  " + driver.getWindowHandle());
		
		//getwindowHandles()
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		Set <String> windowids = driver.getWindowHandles();
		
		for(String winid: windowids) {
			System.out.println("Window Ids are " + winid);	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.quit();
		
	}

	
}
