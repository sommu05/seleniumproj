package day12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//Month and Year as it has Option tag, using select class we used selectbyVisibleText method

public class DatePicker02 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		String date="20";
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		
		//Using Select class
		WebElement months = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select month = new Select(months);
		month.selectByVisibleText("Mar");
		
		WebElement years = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select year = new Select(years);
		year.selectByVisibleText("2020");
		
		
		List <WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement dt : allDates) {
			if(dt.getText().equals(date)) {
				dt.click();
				System.out.println("The selected date is: " + dt.getText());
				break;
				
			}
		}
		
		
		
	}

}
