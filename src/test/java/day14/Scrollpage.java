package day14;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrollpage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		JavascriptExecutor js = driver;
		
		  //1.Scrollpage by pixel     
//        js.executeScript("window.scrollBy(0,3000)","");
//        System.out.println(js.executeScript("return window.pageYOffset;"));       //3039.199951171875  
        
        
          //2.Scrollpage to the target element
//        WebElement deals = driver.findElement(By.xpath("//h2[contains(text(),'Amazon LIVE - Watch, Chat & Shop LIVE ')]"));
//        js.executeScript("arguments[0].scrollIntoView();", deals);
//        System.out.println(js.executeScript("return window.pageYOffset;"));    
//        
        //3. Scrollpage to the end of document/page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");   
        System.out.println(js.executeScript("return window.pageYOffset;"));   //4968 
        
        //4. Scrollpage to the beginning of document/page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");   
        System.out.println(js.executeScript("return window.pageYOffset;"));   //0
        
        driver.quit();
	}

}
