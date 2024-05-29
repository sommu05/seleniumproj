package day15;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.deadlinkcity.com/");
		driver.navigate().refresh();

		// Capturing all the links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + allLinks.size());
		
		int brokenLinks = 0;
		int nonbrokenLinks = 0;
		// Capturing all the href attributes from links
		for (WebElement link : allLinks) {
			String hrefAttributes = link.getAttribute("href");
//			System.out.println(hrefAttributes);

			//Pre-requisites for checking broken link 
			if (hrefAttributes == null || hrefAttributes.isEmpty()) {
				System.out.println("href attribute value is empty");
				continue;
			}

			// Connecting to the server
			
			try {
				@SuppressWarnings("deprecation")
				URL linkURL = new URL(hrefAttributes);                      //Converting string to url format
				// URLConnection conn = linkURL.openConnection();            //no need URL Connection, we need only HTTPURLConnection
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
				conn.connect(); // Connect the server

				// conn.getResponseCode(); //get the responsecode from the server

				//Checking link is broken or not
				
				if (conn.getResponseCode() >= 400) {
					System.out.println(linkURL + " is a broken link");
					brokenLinks++;
				} else {
					System.out.println(linkURL + " is not a broken link");
					nonbrokenLinks++; 
				}
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

			
		}
		
		System.out.println("The total number of broken links are " + brokenLinks);
		System.out.println("The total number of non-broken links are " + nonbrokenLinks);
	}

}
