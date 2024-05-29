package day04;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {

	public static void main(String[] args) {

     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     
     driver.get("https://demo.nopcommerce.com/");
     driver.manage().window().maximize();
     //Absolute xpath
     //driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[2]/form/input")).sendKeys("mac");
     //relative xpath
     //driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button")).click();
     
     //Generated rel xpath
     //String prodName = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[1]/div/div[2]/h2/a")).getText();
     
     //own xpath with xpath function
     String prodName = driver.findElement(By.xpath("//a[normalize-space()='Build your own computer']")).getText();
     System.out.println(prodName);
     
     
     
     
     
     
     
     System.out.println("done");
     driver.quit();
     
	}

}
