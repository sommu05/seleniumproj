package day08;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggested_DropDowns {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Selenium");
		Thread.sleep(3000);

		List<WebElement> suggestions = driver.findElements(By.xpath(
				"//div[@class='left-pane-results-container']//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));

		// Printing the number of auto suggestions
		System.out.println("Total number of webelements: " + suggestions.size());

		// Printing all the auto suggestions
		for (WebElement sug : suggestions) {
			System.out.println(sug.getText());
		}
		
		

		String selectedSuggestion = "";
		for (WebElement sug : suggestions) {
			if (sug.getText().equals("selenium supplement")) {
				sug.click();
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].click();", sug);		
				System.out.println("The selected Auto suggestion: " + sug.getText()); 
				break;
			}
		}

		driver.quit();

	}

}
