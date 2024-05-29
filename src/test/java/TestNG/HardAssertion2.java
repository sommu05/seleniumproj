package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion2 {
  @Test
   void m1() {
	  
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  
	  Assert.assertEquals(1, 2);
	  
	  System.out.println("Completed ");
	  
	  //if any assertion is got failed, the next statements after the assertion will not be executed.
	  //So this is a problem with the hard assertion.
	  
  }
}
