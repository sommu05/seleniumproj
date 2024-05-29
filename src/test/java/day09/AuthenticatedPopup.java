package day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatedPopup {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");    //(http://username:password@the-internet.herokuapp.com/basic_auth)
		driver.manage().window().maximize();
		
		String expectedText = "Congratulations! You must have the proper credentials." ;
		
		String actualText = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).getText();
		
		if(expectedText.equals(actualText)) {
			System.out.println("Test passed");
		}
		else {
			System.out.println("Test failed");
		}
		
		driver.quit();
	}

}
