package zeroBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import zeroBank.base.TestBase;

public class AccountSummary extends TestBase {
	
	/*
	 * URL - http://zero.webappsecurity.com/bank/account-summary.html
	 * Title - Zero - Account Summary
	 */
	
	// DECLARING WEB ELEMENTS 
	
	// Header Buttons + Tabs //  
	@FindBy(partialLinkText = "Account Summary")
	WebElement accountSummaryBtn;
	
	@FindBy(partialLinkText= "Account Activity")
	WebElement accountActivityBtn;
	
	@FindBy(partialLinkText = "Transfer Funds")
	WebElement transferFundsBtn;
	
	@FindBy(partialLinkText = "Pay Bills")
	WebElement payBillsBtn;
	
	@FindBy(partialLinkText = "My Money Map")
	WebElement myMoneyMapBtn;
	
	@FindBy(partialLinkText = "Online Statements")
	WebElement onlineStatementsBtn;
	
	@FindBy(xpath="//div[@id='settingsBox']/ul/li[3]/a")
	WebElement userBtn;
	
	@FindBy(id="logout_link")
	WebElement logoutLink;
	
	//-------------------------------------------------- //
	
	// Account Summary Web Page Specific Elements
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[1]/td[1]/a")
	WebElement savingsBtn_1; // First savings account button.
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[2]/div/div/div[1]/div/table/tbody/tr[2]/td[1]/a")
	WebElement savingsBtn_2; // Second savings account button.
	
	@FindBy(partialLinkText = "Brokerage")
	WebElement brokerageBtn;
	
	@FindBy(partialLinkText = "Checking")
	WebElement checkingBtn;
	
	@FindBy(partialLinkText = "Credit Card")
	WebElement creditCardBtn;
	
	@FindBy(partialLinkText ="Loan")
	WebElement loanBtn;
	
	@FindBy(xpath = ".//h2[contains(text(),'Cash Accounts')]")
	WebElement cashAccountsLabel;
	
	
	// METHODS ----------------------------------------------------------------- // 
	public AccountSummary() {
		PageFactory.initElements(driver, this);
	}
	
	public void validateAccountSummaryTitle() {
		try {
			Assert.assertEquals(driver.getTitle(), "Zero - Account Summary");
			System.out.println("Title has been verified");
		}catch(Exception e) {
			System.out.println("Title not verified.");
		}
		
	}
	
	// checks the webpage to find if the cash accounts label is displayed.
	public void verifyCashAccountsLabel() {
		try {
			Assert.assertTrue(cashAccountsLabel.isDisplayed());
			System.out.println("cashAccountsLabel is displayed!");
		} catch (Exception e) {
			System.out.println("The label has not been displayed");
		}
	}
	
	public boolean checkAccountSummaryButtonSelected() {
		return accountSummaryBtn.isSelected();
	}
	
	// navigates to myMoneyMap
	public MyMoneyMap clickMyMoneyMap() {
		myMoneyMapBtn.click();
		return new MyMoneyMap();
	}
	
	// logs out
	public HomePage logout() {
		userBtn.click();
		logoutLink.click();
		return new HomePage();
	}
	
	// navigates to account activity page
	public AccountActivity clickMyAccountActivity() {
		accountActivityBtn.click();
		return new AccountActivity();
	}
	
} // end of class

