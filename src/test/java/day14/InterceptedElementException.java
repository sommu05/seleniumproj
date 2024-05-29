package day14;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InterceptedElementException {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame-one796456169");
		
		WebElement nameBox = driver.findElement(By.id("RESULT_TextField-0"));
		WebElement male_checkbox = driver.findElement(By.xpath("//input[@name='RESULT_RadioButton-1'][@value='Radio-0']"));
		//nameBox.sendKeys("Welcome to Selenium");
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Welcome to Selenium')", nameBox);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", male_checkbox);
		
		
		System.out.println("Test passed");
		
		
	driver.quit();

	}

}
