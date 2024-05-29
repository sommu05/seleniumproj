package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTo_NewTab_NewWindow {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		//driver.switchTo().newWindow(WindowType.TAB);   //Opens a new Tab
		
		driver.switchTo().newWindow(WindowType.WINDOW);   //Opens a new Window
		
		driver.get("https://chatgpt.com/");
		driver.manage().window().maximize();

		driver.quit();
	}

}
