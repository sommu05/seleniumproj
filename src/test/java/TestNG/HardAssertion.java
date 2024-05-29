package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {

    @Test
	void m1() {
		int a = 20;
		int b = 30;
		
		//Assert.assertTrue(true); //pass    
		//Assert.assertTrue(false); //fail
		
		//Assert.assertFalse(false); //pass
		//Assert.assertFalse(true);  //fail
		
		
		//Format
		//Assert.assertEquals(expected,actual,description) 	
		
		//Assert.assertEquals(a,b); //fail
		//Assert.assertEquals(a>b,true); //fail   expected [true] but found [false]
		//Assert.assertEquals(a<b,false,"A is less than B"); //A is less than B expected [false] but found [true]
		//Assert.assertEquals(a<b,true,"A is less than B"); //pass but no description comes, onl for fail cases description will displayed
	
		//Assert.assertNotEquals(a,b); //pass
		//Assert.assertEquals(1,1); //pass
		//Assert.assertEquals(1,2); //fail
		
//		if(false) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.fail();
//		}

    }
    
    
    
    
}
