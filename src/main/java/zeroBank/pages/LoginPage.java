///http://zero.webappsecurity.com/login.html
//Zero - Log in

package zeroBank.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zeroBank.base.TestBase; 

public class LoginPage extends TestBase {
	
	//Page Factory - OR: 

		@FindBy(id="user_login")
		WebElement usernameBox;
		
		@FindBy(id="user_password")
		WebElement passwordBox;
		
		@FindBy(id="user_remember_me")
		WebElement rememberCheckBox;
		
		@FindBy(id ="credentials")
		WebElement credendtialsreminderHover;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginButton;
		
		@FindBy(linkText="Zero Bank")
		WebElement zeroLogo;
		
		
		
		
		@FindBy(linkText = "Forgot your password ?")
		WebElement forgotpasswordLink;
		
		@FindBy(css = ".alert.alert-error")
		WebElement errorMessage;
		
		@FindBy(className = "tooltip-inner")
		WebElement hoverMessage;
		
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
			
		}
		
		public boolean verifyZeroLogo() {
			return zeroLogo.isDisplayed();
		}
		
		public boolean errorMessageShown() {
			usernameBox.sendKeys("invalid user name");
			passwordBox.sendKeys("invalid password");
			loginButton.click();
			return errorMessage.isDisplayed();
		}
		public boolean hoverForCredentialsShown() throws InterruptedException {
			Actions action = new Actions(driver);
			action.moveToElement(credendtialsreminderHover).build().perform();
			return hoverMessage.isDisplayed();
		
		}
		
		public boolean clickRememberMe() {
			rememberCheckBox.click();
			return rememberCheckBox.isSelected();
		}
		
		public String clickForgotPassword() {
			forgotpasswordLink.click();
			String reset = driver.getCurrentUrl();
			driver.navigate().to("http://zero.webappsecurity.com/login.html");
			return reset;
		}
		
		public String correctLogin() {
			usernameBox.sendKeys("username");
			passwordBox.sendKeys("password");
			loginButton.click();
			return driver.getTitle();
		}
		
		public AccountSummary signIn(String username, String password) {
			usernameBox.sendKeys(username);
			passwordBox.sendKeys(password);
			loginButton.click();
			return new AccountSummary();
		}
		
		
		
		public boolean checkUserNameAutoComplete() {
			// returns true is auto complete is enabled for the username field, else false
			String usernameAuto = usernameBox.getAttribute("autocomplete");
			if(usernameAuto.contentEquals("off")) {
				return false;
			} else {
				return true;
			}
		}
		
		public boolean checkPasswordAutoComplete() {
			// return true if autocomplete is enabled for the password field, else false
			String passwordAuto = passwordBox.getAttribute("autocomplete");
			if(passwordAuto.contentEquals("off")) {
				return false;
			} else {
				return true;
			}
		}
		

}
