package day12;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		WebElement frame01 = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame01);

		// Approach01
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("12/12/2024");
//		System.out.println("Test passed");

		// Approach02
		String month = "September";
		String year = "2026";
		String date = "18";

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();

		// Handled month and year with while loop 
		
		//Here we don't have a Select tagname with option tags for month and year, 
		//so we go with while loop and if condition, suppose if conditions fails, it clicks the right arrow button to change the next month   
		
		while (true) {
			
			String monthName = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yearName = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if (monthName.equals(month) && yearName.equals(year)) {
				String mon = monthName;
				System.out.println("The selected month is: " + mon);
				String yr = yearName;
				System.out.println("The selected month is: " + yr);
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}

		// Handling date with foreach loop

		List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement dt : allDates) {
			if (dt.getText().equals(date)) {
				dt.click();
				System.out.println("The picked date is: " + dt.getText());
				break;

			}
		}
		
		
		// Handling date with normal forloop 

//				List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
//				for (int i = 0; i<=allDates.size() ; i++ ) {
//					if (allDates.get(i).getText().equals(date)) {
//						allDates.get(i).click();
//						System.out.println("The picked date is: " + allDates.get(i).getText());
//						break;
//
//					}
//				}
		
		
		
		
		
		

		driver.quit();

	}

}

//Points to remember:
   //In this datepicker month and year are single webElement --So findElement
   //But dates here are 35 td tags --> So using findElements with List collection

//We can't achieve the date without using List collection because finally we have to perform the click action ( allDates.click() ) ,that we can perform only on webElement   

//while(true) {
//    
//	  String allDates = driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//td")).getText();
//    
//       
//    if(allDates.getText().equals(date)) {
//        String dt = allDates;
//        System.out.println("The selected date is: " + dt);
//        allDates.click();     -->Here it affects
//    	break;
//    }
//    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();     

