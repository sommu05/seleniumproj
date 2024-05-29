package day12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerHiddenOptions {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver(); // Launch the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement txtUsername = driver.findElement(By.name("username"));
		txtUsername.sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

		driver.findElement(By.xpath("//span[text()='Directory']")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]")).click();
		
		List <WebElement> positions = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		String SelectedRole = "Automation Tester";
		for(WebElement role : positions) {
			System.out.println(role.getText());
			if(role.getText().equals(SelectedRole)) {
				role.click();
			}
		}
		driver.quit();
	}

}
