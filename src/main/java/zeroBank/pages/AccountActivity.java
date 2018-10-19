package zeroBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import zeroBank.base.TestBase;

public class AccountActivity extends TestBase{
	
	/*
	 * URL - http://zero.webappsecurity.com/bank/account-activity.html
	 * Title - Zero - Account Activity
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
	
	@FindBy(xpath ="//*[@id=\"ui-tabs-1\"]/h2")
	WebElement showTransactionsLabel;
	
	@FindBy(xpath ="//*[@id=\"tabs\"]/ul/li[2]/a")
	WebElement findTransactionsLabel;
	//-------------------------------------------------- //
	
	// Account Activity Web Page Specific Elements

	@FindBy(xpath ="//*[@id=\"tabs\"]/ul/li[1]/a")
	WebElement showTransactionsTab;
	
	@FindBy(xpath ="//*[@id=\"tabs\"]/ul/li[2]/a")
	WebElement findTransactionsTab;
	
	// drop down for select menu
	@FindBy(id="aa_accountId")
	WebElement accountId;
	
	@FindBy(id="aa_description")
	WebElement description;
	
	@FindBy(id="aa_fromDate")
	WebElement fromDate;
	
	@FindBy(id="aa_toDate")
	WebElement toDate; 
	
	@FindBy(id="aa_fromAmount")
	WebElement fromAmount;
	
	@FindBy(id="aa_toAmount")
	WebElement toAmount;
	
	@FindBy(id = "aa_type")
	WebElement accountType;
	
	@FindBy(partialLinkText = "Find")
	WebElement findBtn;
	
	@FindBy(className = "board-header")
	WebElement boardheader;
	// ----------------------------------------------
	
	//Select selAccount = new Select(accountId);
	//Select selAccountType = new Select(accountType);
	
	
	// METHODS -------------------------------------------------- //
	public AccountActivity() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAccountActivityTitle() {
		try {
			Assert.assertEquals(driver.getTitle(), "Zero - Account Activity");
			System.out.println("Title has been verified");
		}catch(Exception e) {
			System.out.println("Title not verified.");
		}	
	}
	
	// verifies transaction table is displayed
	public void verifyShowTransactionsLabel() {
		try {
			Assert.assertTrue(showTransactionsLabel.isDisplayed(), "showTransactions isn't displayed");
			System.out.println("Show Transaction Label is displayed!");
		}catch(Exception e) {
			System.out.println("Error occured showTransaction Label");
		}
	}
	
	// verifies the find transaction label is displayed
	public void verifyFindTransactionsLabel() {
		try {
			Assert.assertTrue(findTransactionsLabel.isDisplayed(), "findTransactions isn't displayed");
			System.out.println("Find Transaction Label is displayed!");
		}catch(Exception e) {
			System.out.println("Error occured with findTransaction Label");
		}
	}
	
	public void switchToShowTransactionsLabel() {
		try {
		if(showTransactionsLabel.isDisplayed() && showTransactionsLabel.isEnabled()) 
			showTransactionsLabel.click();
		
		if(boardheader.getText().equalsIgnoreCase("show transactions"))
			System.out.println("Already on the show transactions tab.");
		else
			System.out.println("Now on the show transactions tab!");
			Thread.sleep(1400);
		}catch(Exception e) {
			System.out.println("The showTransactionsLabel is already selected.");
		}
	}
	
	public void switchToFindTransactionsLabel() {
		try {
		if(findTransactionsLabel.isDisplayed() && findTransactionsLabel.isEnabled()) 
			findTransactionsLabel.click();
		
		if(boardheader.getText().equalsIgnoreCase("find transactions"))
			System.out.println("Already on the find transactions tab.");
		else
			System.out.println("Now on the find transactions tab!");
			Thread.sleep(1400);
		}catch(Exception e) {
			System.out.println("The findTransactionsLabel is already selected.");
		}		
	}
	
	// tries to see if the showTransaction tab is selected
	public boolean checkShowTransactionsTabSelected() {
		return showTransactionsTab.isSelected();
	}
	
	// tries to see if the findtransactionTab is selected
	public boolean checkFindTransactionsTabSelected() {
		return findTransactionsTab.isSelected();
	}
	
	
	
	
	
}// end of class
