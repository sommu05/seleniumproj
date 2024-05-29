package day10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//Getwindowhandle()
		//String SingleWinndowid = driver.getWindowHandle();  
		//System.out.println(SingleWinndowid);    //CB9ABC8E82949E88FF2DFF803E86BE1B
		
		
		
		
		
		//Getwindowhandles()
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set <String> Windowids = driver.getWindowHandles();   
		
		//In set collection we can do forloop to get the browser windowids 
//		for(String winid: Windowids) {
//			System.out.println("The windowids are:" + winid);
//		}
		
		//The windowids are:CB9ABC8E82949E88FF2DFF803E86BE1B
		//The windowids are:E1455FC0F13798DD3C560387EC162FCC
		//Here we don't know which id is for which Browser window, So we can achieve this with two approaches
		
		
		
		
		//Approach01 --> Converting the set collection to List collection
		
		List<String> listwinids = new ArrayList(Windowids);    //passing the set collection into the Array list, now we can able to access through get method
		String parentWindowid = listwinids.get(0);
		String childWindowid = listwinids.get(1);
		System.out.println(parentWindowid);
		System.out.println(childWindowid);
		
		driver.switchTo().window(childWindowid);
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		
		driver.switchTo().window(parentWindowid);
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Alagu");
		
		driver.quit();
		

	}

}
