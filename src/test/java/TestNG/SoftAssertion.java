package TestNG;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

	@Test
	void m2() {
		
	SoftAssert sa = new SoftAssert();
	
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	 	  
	  sa.assertEquals(1, 2);
	
	  System.out.println("Completed ");
	  
	  sa.assertAll(); //mandatory this will invoke all kinds of soft assertions
	  
	  //In Soft assertion if any assertion is got failed, the next statements after the assertion will be executed.
	  
	}
	
	
}
