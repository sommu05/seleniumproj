package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CSSLocator {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		
		//tagname & id 
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Mac");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Mac");        // without tagname, tagname is optional
		
		
		//tagname & class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Mac");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Mac");      // without tagname, tagname is optional
		
		
		//tagname & attribute
		//driver.findElement(By.cssSelector(" input[type=\"text\"] ")).sendKeys("Mac");   //Regular expression in Java -- putting backward slash before double quotation
		//driver.findElement(By.cssSelector(" input[placeholder='Search store'] ")).sendKeys("Mac");
		//driver.findElement(By.cssSelector(" [placeholder='Search store'] ")).sendKeys("Mac");  // without tagname, tagname is optional
		
		
		//tagname, class & attribute
		//driver.findElement(By.cssSelector("input.search-box-text[type='text']")).sendKeys("Mac");
		driver.findElement(By.cssSelector("input.search-box-text[type='text']")).sendKeys("Mac");   // without tagname, tagname is optional
		
		
		
		
		
		
		
		
		
		
		System.out.println("Done");
		driver.quit();

	}

}
