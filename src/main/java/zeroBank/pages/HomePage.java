//http://zero.webappsecurity.com/index.html
//Zero - Personal Banking - Loans - Credit Cards

package zeroBank.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zeroBank.base.TestBase; 

public class HomePage extends TestBase{
	
	@FindBy(linkText="Zero Bank") // logo on top left
	WebElement zeroLogo;
	
	@FindBy(linkText = "Online Bank")
	WebElement onlinebankLink;
	
	@FindBy(id="feedback")
	WebElement feedbackLink;
	
	@FindBy(id = "signin_button")
	WebElement signinButton;
	
	@FindBy(xpath ="//img[contains(@src,'/resources/img/main_carousel_1.jpg')]")
	WebElement coinsImg;
	
	@FindBy(id = "online-banking")
	WebElement moreservicesButton;
	
	@FindBy(id = "account_activity_link")
	WebElement accountactivityLink;
	
	@FindBy(id = "transfer_funds_link")
	WebElement transferfundsLink;

	@FindBy(id = "money_map_link")
	WebElement moneymapLink;

	@FindBy(id="searchTerm")
	WebElement searchBar;
	
	@FindBy(className = "icon-cog")
	WebElement settingsIcon;
	
	@FindBy(className = "icon-user")
	WebElement userIcon;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void sb(String phrase) {
		searchBar.sendKeys(phrase);
	}
	
	public String validateHomePageTitle() {
		sb("Home Page Title Verified....");
		return driver.getTitle();
		
	}
	
	public boolean verifyZeroLogo() {
		// returns true (false) if the logo is (is not) displayed
		sb("Zero Logo Verified....");
		return zeroLogo.isDisplayed();
	}
	
	public LoginPage clickSignIn() {
		signinButton.click();
		return new LoginPage();
	}
	
	public boolean signInDisplayed() {
		return signinButton.isDisplayed();
	}
	
	public boolean onlineBankingIsDisplayed() {
		return moreservicesButton.isDisplayed();
	}
	
	public boolean accountActivityLinkIsDisplayed() {
		return accountactivityLink.isDisplayed();
	}
	
	
	public boolean myMoneyMapIsDisplayed() {
		return moneymapLink.isDisplayed();
	}

	
	public MyMoneyMap clickMyMoneyMapLink() {
		moneymapLink.click();
		return new MyMoneyMap();
	}
	
	public FeedbackPage clickOnFeedbackLink() {
		feedbackLink.click();
		return new FeedbackPage();
	}
}
