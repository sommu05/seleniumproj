package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

		WebElement button = driver.findElement(By.xpath("//span[normalize-space()='right click me']"));
		WebElement quit= driver.findElement(By.xpath("//span[text()='Quit']"));
		
		//Actions class will take driver instance as argument
		
		Actions act = new Actions(driver);
		act.contextClick(button).perform();
		Thread.sleep(3000);
		quit.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		driver.quit();
	}

}