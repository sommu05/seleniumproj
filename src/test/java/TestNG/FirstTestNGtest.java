package TestNG;

import org.testng.annotations.Test;

public class FirstTestNGtest {

	@Test 
	void openApp() {
		System.out.println("Test Passed");
	}
	
	@Test 
	void loginApp() {
		System.out.println("Hello Java");
	}
	
	@Test 
	void logoutApp() {
		System.out.println("Helo World");
	}
	
}
