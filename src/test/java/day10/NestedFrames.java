package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NestedFrames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
	
		
		//Switching to Frame01
		//No id or name here , So identifying frame as webelement
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));    //Identifying webElement as frame 
		driver.switchTo().frame(frame1);          //Switching to Frame
		
		driver.findElement(By.name("mytext1")).sendKeys("Unnamulai thaayar");
		driver.switchTo().defaultContent();
		
		//Switching to Frame03
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));    //Identifying webElement as frame 
		driver.switchTo().frame(frame3);          //Switching to Frame
		driver.findElement(By.name("mytext3")).sendKeys("Nataraja Perumaan");
		
		//Here only one iframe in frame03 , So Switching to innerframe with index value as 0
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("div.AB7Lab")).click();
		
		System.out.println("Test passed");
		
	
		
	}

}
