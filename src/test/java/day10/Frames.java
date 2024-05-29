package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.name("RESULT_TextField-0")).sendKeys("Sommu Alagappan");
		driver.findElement(By.cssSelector("input#FSsubmit")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("input.form-control[id='name']")).sendKeys("Annamalaiyaar");
		
		System.out.println("Test passed");
		
		driver.quit();

	}

}
