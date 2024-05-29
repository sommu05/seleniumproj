package day08;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithSelectTag {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		
		WebElement countries = driver.findElement(By.xpath("//select[@id='country-list']"));
		Select drpCountry = new Select(countries);
		drpCountry.selectByVisibleText("India");
		
		WebElement states = driver.findElement(By.xpath("//select[@id='state-list']"));
		Select drpState = new Select(states);
        drpState.selectByVisibleText("Tamil Nadu");
		//drpState.selectByValue("21");
		//drpState.selectByIndex(3);
        
        
		
		//Printing number of options and their names
        
        List<WebElement> countryDetails = drpCountry.getOptions();
        System.out.println("The number of countries: "+ countryDetails.size());
        
        for(WebElement countryNames: countryDetails) {
        	System.out.println(countryNames.getText());
        }
        
        
        driver.quit();
	}

}
