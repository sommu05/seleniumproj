package day02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalLocators_FindElements {

	public static void main(String[] args) {
	
		//To find the number of slides in the webpage
		
		WebDriverManager.chromedriver().setup(); //Setting up WebDrivermanager
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		
		//Find number of slides
		WebElement Slider =  driver.findElement(By.className("carousel-indicators"));
		List<WebElement> slides =  Slider.findElements(By.tagName("li"));
		System.out.println("The number of slides is: "+ slides.size());
		
		//Find number of images in the webpage
		List<WebElement> images=  driver.findElements(By.tagName("img"));
		System.out.println("The number of images is: "+ images.size());
		
		//Find number of hyperlinks in the webpage
		List<WebElement> links=  driver.findElements(By.tagName("a"));
		System.out.println("The number of links is: "+ links.size());
		
		//Secnario03 - locator is incorrect
		List<WebElement> marker=  driver.findElements(By.tagName("marker"));
		System.out.println("The number of markers is: "+ marker.size());    //0 It returns 0
		
		try {
			WebElement mark= driver.findElement(By.tagName("marker"));
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
        driver.quit();
	}

}
