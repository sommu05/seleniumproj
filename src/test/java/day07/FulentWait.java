package day07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FulentWait {

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				       .withTimeout(Duration.ofSeconds(10))
				       .pollingEvery(Duration.ofSeconds(2))
				       .ignoring(NoSuchElementException.class);

			
			//get(url)
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			
			
				   WebElement foo = mywait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) {
				       return driver.findElement(By.name("username"));
				     }
				   });
			
			foo.sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin12");
			
			System.out.println("Test case passed");
			driver.quit();

		}

	}