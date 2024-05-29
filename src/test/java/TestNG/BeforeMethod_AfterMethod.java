package TestNG;

import org.testng.annotations.*;

public class BeforeMethod_AfterMethod {

	@BeforeMethod
	void login() {
		System.out.println("I'm BeforeMethod");
	}

	@Test (priority=1)
	void search() {
		System.out.println("I'm Search");
	}

	@AfterMethod
	void logout() {
		System.out.println("I'm AfterMethod");
	}

	
	
	@Test (priority=2)
	void Advancedsearch() {
		System.out.println("I'm AdvancedSearch");
	}

}
