package day08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//Checking the specific checkbox
		//driver.findElement(By.id("thursday")).click();
		
		
		//Checking all checkboxes
		
		List<WebElement> checkboxes =   driver.findElements(By.cssSelector("input.form-check-input[type='checkbox']"));
		System.out.println("Total no.of checkboxes:" + checkboxes.size());    //Total number of checkboxes
		
//		for(int i=0;i<checkboxes.size();i++) {     //Normal forloop:
//			checkboxes.get(i).click();
//		}	
//		
//		for (WebElement chkbox: checkboxes){     //Enhanced forloop
//			chkbox.click();
//		}
		
		//Checking the first two check boxes:
		
		for (int i=0; i<checkboxes.size();i++) {
			if (i<2) {
				checkboxes.get(i).click();
			}
			
		}
		
		
		//Checking the last two check boxes:
		
		//Formula: Total number of check boxes - how many check boxes to be selected
        //7 - 2 = 5
        //So here 5 will be the starting index
		
//		for (int i=5;i<checkboxes.size();i++) {
//			checkboxes.get(i).click();
//		}
		
		
		//Unchecking the check boxes:
		
//		     for (WebElement chkbox: checkboxes) {
//		    	 if(chkbox.isSelected()) {
//		    		 chkbox.click();
//		    	 }
//		     }

		//Printing the checkbox names which are selected, here we achieve this getAttribute method
		
		for(WebElement chkbox: checkboxes) {
			if(chkbox.isSelected()) {
				System.out.println("The clicked checkboxes are: "+chkbox.getAttribute("value"));
			}
		}
		
		
		driver.quit();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
