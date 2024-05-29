package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		WebElement desktop = driver.findElement(By.xpath("//a[text()='Desktops']"));
		WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		//Actions class will take driver instance as argument
		
		Actions act = new Actions(driver);
		act.moveToElement(desktop);
		act.moveToElement(mac).click().build().perform();
		
		driver.quit();
	}

}
