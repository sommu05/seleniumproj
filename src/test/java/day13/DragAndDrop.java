package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
	

		WebElement copenhagesn= driver.findElement(By.xpath("//div[@id='box4']"));
		WebElement Italy= driver.findElement(By.xpath("//div[@id='box107']"));
		
		WebElement madrid= driver.findElement(By.xpath("//div[@id='box7']"));
		WebElement US= driver.findElement(By.xpath("//div[@id='box103']"));
		
		
		//Actions class will take driver instance as argument
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(copenhagesn, Italy).perform();
		Thread.sleep(3000);
		
		act.dragAndDrop(madrid, US).perform();
		Thread.sleep(3000);
       
		
		driver.quit();
	}

}