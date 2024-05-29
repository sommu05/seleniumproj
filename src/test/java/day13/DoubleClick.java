package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		driver.manage().window().maximize();
		
		
		driver.switchTo().frame("iframeResult");

		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Double-click me']"));
		WebElement response= driver.findElement(By.xpath("//p[@id='demo']"));
		
		//Actions class will take driver instance as argument
		
		Actions act = new Actions(driver);
		
		act.doubleClick(button).perform();
		Thread.sleep(3000);
        
		 if(response.getText().equals("Hello World")) {
			 System.out.println("Test passed");
		 }
		 else {
			 System.out.println("Test failed");
		 }
		
		
		driver.quit();
	}

}

