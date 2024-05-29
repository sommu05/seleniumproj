package day09;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		driver.switchTo().alert().accept();

//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		//driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
//		
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(3000);
		System.out.println(alert.getText());
		alert.sendKeys("welcome");
		alert.accept();
		
		System.out.println("Test passed");
		
		driver.close();
		
		

	}

}
