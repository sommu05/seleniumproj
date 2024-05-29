package day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Screenshots {

	public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
	
	
	
	//Capture fullpage Screenshot
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File trg = new File("C:\\Users\\hp\\eclipse-workspace\\Selenium\\Screenshots\\FullScreeshot1.png");
	
	//Special class in Java not in any Interface
	FileUtils.copyFile(src, trg);     //class from Java
	
	
	//Capture Particular WebElement Screenshot
	WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cbc0f326-c90a-40d6-9b34-2c390bea1bf0']")));
	File src1 = ele.getScreenshotAs(OutputType.FILE);
	File trg1 = new File("C:\\Users\\hp\\eclipse-workspace\\Selenium\\Screenshots\\Particular_Element.png");
	FileUtils.copyFile(src1, trg1);  
	
	
	driver.quit();
	}

	
	
}
