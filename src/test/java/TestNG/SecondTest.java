package TestNG;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondTest {
	WebDriver driver;

	@Test(priority = 1)
	void openApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();

	}

	@Test(priority = 2)
	void loginApp() {
		WebElement txtUsername = driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin12");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Test(priority = 3)
	void closeApp() {
		driver.quit();
	}

}
