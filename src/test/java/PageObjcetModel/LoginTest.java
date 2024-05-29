package PageObjcetModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	LoginPage02 lp;
	//LoginPage01 lp; 
	
	@BeforeClass
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test (priority=1)
	void testLogo() {
		lp = new LoginPage02 (driver); 	
		Assert.assertEquals(lp.checkLogoDisplay(),true);
	}
	@Test (priority=2)
	void testLogin() {
		lp.setUsername("admin");
		lp.setPassword("admin123");
		lp.btn_login.click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
}
