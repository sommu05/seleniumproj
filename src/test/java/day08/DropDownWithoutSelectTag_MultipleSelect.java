package day08;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelectTag_MultipleSelect {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

        // Click the dropdown button
        driver.findElement(By.xpath("//button[@type='button']")).click();

        // Find all program options
        List<WebElement> programs = driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//label"));

        // Total number of programs
        System.out.println("Total number of programs: " + programs.size());

        // List to store individually selected programs
        List<String> individuallySelectedPrograms = new ArrayList<>();

        
        // Selecting multiple dropdowns in normal forloop    - Only for normal forloop we have to use get(i) its must
        for (int i=0; i<programs.size(); i++) {
            String name = programs.get(i).getText();
            if (name.equals("Java") || name.equals("Python")) {
                programs.get(i).click();
                individuallySelectedPrograms.add(name);
        
            }
        }
        
        // Selecting multiple dropdowns in enhanced forloop
        for (WebElement program : programs) {
            String name = program.getText();
            if (name.equals("Java") || name.equals("Python")) {
                program.click();
                individuallySelectedPrograms.add(name);
        
            }
        }
        
        // Print the individually selected programs
        System.out.println("The individually selected programs are: " + individuallySelectedPrograms);  // [Java, Python]

        driver.quit();
    }
}
