package day06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalCommands {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.manage().window().maximize();
		//Thread.sleep(3000);
		
		//WebElement status =  driver.findElement(By.xpath("(//img[@alt='orangehrm-logo'])[2]"));
		//div[@class='orangehrm-login-logo']/img -  xpath
		//div.orangehrm-login-logo-mobile  - css Selector  

		
		//isDisplayed()
		//System.out.println("Web element is present: " + status.isDisplayed());

		
		//isEnabled()
		//Boolean status2 =  driver.findElement(By.cssSelector(".oxd-input[name='username']")).isEnabled();
		//System.out.println("Web element is enabled: " +   status2 );
		
		
		//isSelected()
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		WebElement mal_rd = driver.findElement(By.cssSelector("#gender-male"));;
		WebElement femal_rd = driver.findElement(By.cssSelector("#gender-female"));

        System.out.println("Before selecting radio button");
        System.out.println(mal_rd.isSelected());  //false
        System.out.println(femal_rd.isSelected()); //false
		
        System.out.println("After selecting male radio button");
        mal_rd.click();
        System.out.println(mal_rd.isSelected()); //true
        System.out.println(femal_rd.isSelected()); //false
        
        
		driver.quit();
	}

}
