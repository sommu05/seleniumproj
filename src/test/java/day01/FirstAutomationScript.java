package day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstAutomationScript {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver(); // Launch the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement txtUsername = driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin12");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);

		String actual_text = "";
		try {
			actual_text = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"))
					.getText();
		} catch (Exception e) {};

		String expected_text = "Dashboard";

		if (actual_text.equals(expected_text)) {
			System.out.println("Test passed");
		} else {
			System.out.println("Test failed");
		}
		driver.close();
	}

}