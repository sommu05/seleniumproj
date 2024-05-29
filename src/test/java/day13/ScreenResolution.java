package day13;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenResolution {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/slider/range.html");
		
		driver.manage().window().maximize();
	
		Thread.sleep(2000);
		driver.manage().window().minimize();
		
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		
		Thread.sleep(2000);
		Point p = new Point(100,100);
		driver.manage().window().setPosition(p);

		driver.quit();
		System.out.println("Test passed");
	}

}
