package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

//1) Find total number of rows

		// Like this also we can write or we can directly apply the size method which
		// reduces the code to single line
//		List<WebElement> rows =  driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));
//		rows.size();

		int rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		System.out.println("The number of rows " + rows);

		// int rowss = driver.findElements(By.tagName("tr")).size(); //This is
		// preferable when you have only one table in the webpage
		// System.out.println(rowss);

//2) Find total number of columns - Columns always go for <th> table header tag

		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("The number of columns " + columns);

//3) Read specific row & column data   --> Selenium 

		String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[3]")).getText();
		System.out.println(value);

//4) Read data from all the rows & columns

		for (int r = 2; r <= rows; r++) { // r=2 because we don't need th, here no index only positions starts from 1
											// only
			for (int c = 1; c <= columns; c++) { // here I' going to take td only so c=1
				String values = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[" + c + "]"))
						.getText();
				System.out.print(values + "           ");
			}
			System.out.println();
		}

//5) Print book names whose author is Amit -->Single loop is enough
		for (int r = 2; r <= rows; r++) {
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[2]")).getText();
			if (author.equals("Amit")) {
				String books = driver.findElement(By.xpath("//table[@name='BookTable']//tr[" + r + "]//td[1]")).getText();
				System.out.println(books + " " + author);

			}

		}

//6) Find sum of prices for all the books      Have to check row or column which is changing in the loop, that one we have to pass it as dynamic, here column remains same 4th column, but row each time in loop changing 
		int sum = 0;
		for (int r=2; r<=rows; r++) {
			
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			sum = sum + Integer.parseInt(price);		
		}
		
		System.out.println("The total amount is " + sum );
		
// Interview question --> Retrieve the row value and column value for "Animesh" 
		//Step01: For this first we have to take the number of rows and columns using size method like below separately then start proceeding
		
		int rowCount = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		for(int r=2; r<=rowCount; r++) {           //as we are mentioning the <td> in 3rd line xpath, we must change the row starting index r=2, otherwise wise it will read the <th> value, so we shouldn't allow row to read the <th> value.
			for(int c=1; c<=colCount; c++  ) {
				String name = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				if(name.equals("Animesh")) {
					System.out.println("The row value is "+ r + " " + "The column value is " + c  );
					break;
				}
			}
		}
		
	}
	//Points to remember:
	//as we are mentioning the <td> in 3rd line xpath, we must change the row starting index r=2, otherwise wise it will read the <th> value, so we shouldn't allow row to read the <th> value.

}
