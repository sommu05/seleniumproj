package day07;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitOldSyntax {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Declaration of Fluent wait
		FluentWait mywait = new FluentWait(driver);
		mywait.withTimeout(Duration.ofSeconds(10));
		mywait.pollingEvery(Duration.ofSeconds(10));
		mywait.ignoring(NoSuchElementException.class);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		//Usage of Fluent wait command - Here Fluent wait returns object, So we to typecasting and convert it into webelement 
		WebElement username =(WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.sendKeys("Admin");
		
		WebElement password =(WebElement) mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("admin123");
	
        System.out.println("Test case passed");
		driver.quit();

	}

}
