package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DummyTicketBooking {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/");

		//Page01
		driver.findElement(By.xpath("//div[contains(@class,'ffb-id-1bt552nb')]//span")).click();
		
		//Page02
		driver.findElement(By.xpath("//input[@value='549']")).click();
        driver.findElement(By.id("travname")).sendKeys("Sommu Alagapppan");
        driver.findElement(By.id("travlastname")).sendKeys("M");
        WebElement dateofBirth = driver.findElement(By.id("dob"));
        dateofBirth.click();
        
        WebElement monthofbirth = driver.findElement(By.cssSelector(".ui-datepicker-month"));
        Select month= new Select(monthofbirth);
        month.selectByValue("4");
        
        WebElement yearofbirth = driver.findElement(By.cssSelector(".ui-datepicker-year"));
        Select year= new Select(yearofbirth);
        year.selectByValue("1996");
        
        List <WebElement> date = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
        String selectedDate = "5";
        for (WebElement dt: date) {
        	if(dt.getText().equals(selectedDate)) {
        		dt.click();
        	}
        }
        
        
        
        
	}

}
