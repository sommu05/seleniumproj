package TestNG.pack1;

import org.testng.annotations.*;

public class Class02 {
	
  @Test 
  void m2() {
	  System.out.println("I'm class02");
	  
  }
  
  
  @BeforeTest
  void a1() {
	  System.out.println("I'm Before Test");
  }
  
  @AfterTest
  void a2() {
	  System.out.println("I'm After Test");
  }
  
  
  @BeforeSuite
  void a3() {
	  System.out.println("I'm Before Suit");
  }
  
  @AfterSuite
  void a4() {
	  System.out.println("I'm After Suit");
  }
  
}
