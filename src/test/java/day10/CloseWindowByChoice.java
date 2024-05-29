package day10;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseWindowByChoice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();

		// getWindowHandles()
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String> Windowids = driver.getWindowHandles();
		
		
		//Close window by choice, So whatever windows we have to close, We have to capture all the windowids using forloop then capture titles using .getTitle(), 
		// in if condition if captured title and actual title matches those windows will be closed. 
		
		
		
		for(String winids: Windowids) {
			String title = driver.switchTo().window(winids).getTitle();
			
			if( title.equals("OrangeHRM") || title.equals("Human Resources Management Software | OrangeHRM") ) {
				driver.close();
			}
		}
		
		System.out.println("Test passed");
		
		
		
	}

}
