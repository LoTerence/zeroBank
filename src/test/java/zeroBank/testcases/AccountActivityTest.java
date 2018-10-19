package zeroBank.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zeroBank.base.TestBase;
import zeroBank.pages.AccountActivity;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.HomePage;
import zeroBank.pages.LoginPage;
import zeroBank.util.TestUtil;

public class AccountActivityTest extends TestBase {

	
	AccountSummary accountSummary;
	AccountActivity accountActivity;
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	

	public AccountActivityTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();		
		accountActivity = new AccountActivity();
		accountSummary = new AccountSummary();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtil = new TestUtil();

		loginPage = homePage.clickSignIn();
		accountSummary = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		accountActivity = accountSummary.clickMyAccountActivity();
	}
	
	@Test ( priority =1 )
	public void verifyPageTitle() {
		accountActivity.verifyAccountActivityTitle();
		System.out.println("verifyPageTitle complete!");
	}
	
	@Test(priority=2)
	public void verifyLabelsAreDisplayed() {
		try {
			accountActivity.verifyFindTransactionsLabel();
			accountActivity.verifyShowTransactionsLabel();
			System.out.println("Both Find/Show labels are showing properly!");
		}catch(Exception e) {
			System.out.println("Labels are not being displayed correctly.");
		}
	
	}
	
	@Test(priority=3)
	public void switchToShowTransactionsLabel() {
		try {
			accountActivity.switchToShowTransactionsLabel();
		}catch(Exception e) {
			System.out.println("There was an issues switching between your tabs");
		}
	}
	
	@Test(priority=4)
	public void switchToFindTransactionsLabel() {
		try {
			accountActivity.switchToFindTransactionsLabel();
		}catch(Exception e) {
			System.out.println("There was an issues switching between your tabs");
		}
	}
	
	@Test(priority=5)
	public void switchBetweenTheTabs() {
		accountActivity.switchToFindTransactionsLabel();
		accountActivity.switchToShowTransactionsLabel();
		accountActivity.switchToFindTransactionsLabel();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		
	}
}
