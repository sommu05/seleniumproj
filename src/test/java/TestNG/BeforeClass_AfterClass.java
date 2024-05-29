package TestNG;

import org.testng.annotations.*;

public class BeforeClass_AfterClass {

	@BeforeClass
	void login() {
		System.out.println("I'm BeforeClass");
	}

	@Test (priority=1)
	void search() {
		System.out.println("I'm Search");
	}

	@AfterClass
	void logout() {
		System.out.println("I'm AfterClass");
	}

	
	
	@Test (priority=2)
	void Advancedsearch() {
		System.out.println("I'm AdvancedSearch");
	}

}