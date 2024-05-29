package PageObjcetModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page Factory Approach

public class LoginPage02 {

	WebDriver driver;
	
	//Constructor
	LoginPage02(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	//Locators
	@FindBy(xpath="//img[@alt='company-branding']") WebElement img_logo;
	
	@FindBy(name="username") WebElement txt_userName;
	
	@FindBy(name="password") WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']") WebElement btn_login;
	

   //Action Methods
    public boolean checkLogoDisplay() {
    	boolean status = img_logo.isDisplayed();
    	return status;
    } 
    
    public void setUsername(String username) {
    	txt_userName.sendKeys(username);
    }
    
    public void setPassword(String password) {
    	txt_password.sendKeys(password);
    }
    
    public void clickLogin() {
    	btn_login.click();
    }











}
