package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class HeadlessTesting {

	public static void main(String[] args) throws InterruptedException {
		
		
        // Headless mode
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless=new");
//		  WebDriver driver = new ChromeDriver(options); // Launch the browser
		
//		EdgeOptions options = new EdgeOptions();
//		options.addArguments("--headless=new");
//		WebDriver driver = new EdgeDriver(options); // Launch the browser
		
		FirefoxOptions options = new FirefoxOptions();
		options.addArguments("--headless=new");
		WebDriver driver = new FirefoxDriver(options); // Launch the browser
        
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
		
		
		Thread.sleep(5000);
		WebElement txtUsername = driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin12");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);

		String actual_text = "";
		try {
			actual_text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
		} catch (NoSuchElementException e) {}

		String expected_text = "Invalid credentials";

		if (actual_text.equals(expected_text)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		//driver.close();
		driver.quit();

	}

}


