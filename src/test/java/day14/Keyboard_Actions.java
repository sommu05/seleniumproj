package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard_Actions {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement textBox1 = driver.findElement(By.id("inputText1"));
		textBox1.sendKeys("Welcome to Selenium");
		
		Actions act = new Actions(driver);
		
		//ctrl+a
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
		//ctrl+c
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        
		//tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        //act.sendKeys(Keys.TAB);    //No need up and down if its only a single key
        
		Thread.sleep(2000);
		//ctrl+v
		act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		
		System.out.println("Test passed");
		
		driver.quit();
        
	}

}

