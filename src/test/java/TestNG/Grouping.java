package TestNG;

import org.testng.annotations.Test;

public class Grouping {
	
  @Test(priority=1, groups= {"sanity"})
  void login() {
	  System.out.println("login");
  }
  
  @Test(priority=2, groups= {"sanity","regression","sr"})
  void search() {
	  System.out.println("search");
  }
  
  @Test(priority=3, groups= {"regression"})
  void advancedsearch() {
	  System.out.println("advancedsearch");
  }
  
  @Test(priority=4, groups= {"sanity"})
  void logout() {
	  System.out.println("logout");
  }
  
  @Test(priority=5, groups= {"sanity","regression","sr"})
  void closeApp() {
	  System.out.println("closeApp");
  }
}
