package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropBy_Slider {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resources/demos/slider/range.html");
		driver.manage().window().maximize();
	

		WebElement min_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		WebElement max_slider = driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		System.out.println("The current location of min slider is: " + min_slider.getLocation());
		System.out.println("The current location of max slider is: " + max_slider.getLocation());
		
		//Actions class will take driver instance as argument
		
		Actions act = new Actions(driver);
		
		Thread.sleep(3000);
		
		act.dragAndDropBy(min_slider, 350, 47).perform();    //Perform is must
		System.out.println("After changes the location of min slider is: " + min_slider.getLocation());
		act.dragAndDropBy(max_slider, -300, 47).perform();
		System.out.println("After changes the location of min slider is: " + max_slider.getLocation());
		
		
		
		
		driver.quit();
	}

}