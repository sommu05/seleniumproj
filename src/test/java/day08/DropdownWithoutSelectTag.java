package day08;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownWithoutSelectTag {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");

		List<WebElement> countries = driver.findElements(By.xpath("//select[@id='country-list']//option"));
		
		System.out.println("Total number of countries: "+ countries.size());    //Total number of countries
		
        String selectedCountry = "";
        String selectedState= "";
	
        
		for (WebElement x : countries) {	
			
			String countryNames = x.getText();
			if (countryNames.equals("Brazil")) {
				x.click();
				selectedCountry = countryNames;
				break;
			}
		}
Thread.sleep(3000);
        List<WebElement> states = driver.findElements(By.xpath("//select[@id='state-list']//option"));
        
		for (WebElement y : states) {

			String statesNames = y.getText();
			if (statesNames.equals("Ceara")) {
				y.click();
				selectedState = statesNames;
				break;
			}

		};
		System.out.println("The selected country is: "+ selectedCountry );
		System.out.println("The selected State is: "+ selectedState  );
		
		System.out.println("Test case passed");
		driver.quit();

	}

}
