package day10;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Approach02getwindowhandles {

	public static void main(String[] args) throws InterruptedException {

		// forloop with matching the title

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();

		// getWindowHandles()
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String> Windowids = driver.getWindowHandles();

		//Switch to second window 
		for (String winids : Windowids) {
			
			String title = driver.switchTo().window(winids).getTitle();
			if (title.equals("Human Resources Management Software | OrangeHRM")) {
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
			} 
			System.out.println(winids);
		}
		
		
		//Switch back to main window 
		for (String winids : Windowids) {

			String title = driver.switchTo().window(winids).getTitle();

			if (title.equals("OrangeHRM")) {
				Thread.sleep(3000);
				driver.findElement(By.name("username")).sendKeys("Alagu");
				}
			System.out.println(winids);
		}
		
		
		System.out.println("Test passed");

}}
