package zeroBank.pages;

//http://zero.webappsecurity.com/forgot-password.html
//Zero - Forgotten Password

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zeroBank.base.TestBase; 

public class ForgotPage extends TestBase {
	
	@FindBy(id="user_email")
	WebElement useremailBox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement sendpasswordButton;
	
	@FindBy(xpath = "a[@href='http://zero.webappsecurity.com/index.html']")
	WebElement brandLink;
	
	
	public ForgotPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateForgotPageTitle() {
		return driver.getTitle();
		
	}

	
	

}