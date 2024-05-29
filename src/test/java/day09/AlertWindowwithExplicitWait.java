package day09;


import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AlertWindowwithExplicitWait {

	//If we face any Synchronization problem we can use Explicitwait
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = mywait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        alert.sendKeys("welcome");
        alert.getText();
        alert.accept();
        
        System.out.println("Test passed");
        
        driver.quit();
	}

}
