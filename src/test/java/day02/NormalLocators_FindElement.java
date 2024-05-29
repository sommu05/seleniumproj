package day02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NormalLocators_FindElement {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup(); //Setting up WebDrivermanager
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		driver.findElement(By.linkText(" Products")).click();
    	driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")).click();
		driver.findElement(By.name("search")).sendKeys("green");
		driver.findElement(By.id("submit_search")).click();
		Thread.sleep(3000);
		
		String exp_text="SEARCHED PRODUCTS";
		String act_text = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/h2")).getText();

		if (exp_text.equals(act_text)) {
			System.out.println("Text case Passed");
		}
		else {
			System.out.println("Test case failed");
		}
		driver.quit();
	}

}
