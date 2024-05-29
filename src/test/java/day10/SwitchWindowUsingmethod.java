package day10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindowUsingmethod {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // getWindowHandles()
        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> listWindowHandles = new ArrayList<>(windowHandles); // Changed variable name and corrected ArrayList declaration
        
        // Call the switchWindow method
        switchWindow(driver, "Human Resources Management Software | OrangeHRM", listWindowHandles);
        switchWindow(driver, "OrangeHRM", listWindowHandles); 
        switchWindow(driver, "Human Resources Management Software | OrangeHRM", listWindowHandles);
        
        driver.quit();
    }

    // Method to switch to a window based on its title
    static void switchWindow(WebDriver driver, String windowTitle, List<String> windowHandles) {
        for (String windowHandle : windowHandles) {
        	String title = driver.switchTo().window(windowHandle).getTitle();
            if (title.equals(windowTitle)) {
                System.out.println("Found the correct window: " + title);
            }
        }
    
    }
}
