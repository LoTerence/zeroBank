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

public class AccountSummaryTest extends TestBase {

	
	AccountSummary accountSummary;
	TestUtil testUtil;
	AccountActivity accountActivity;
	LoginPage loginPage;
	HomePage homePage;
	
	public AccountSummaryTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		accountSummary = new AccountSummary();
		homePage = new HomePage();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		
		loginPage = homePage.clickSignIn();
		accountSummary = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void verifyAccountSummaryTitle() {
		accountSummary.validateAccountSummaryTitle();
		System.out.println("verifyAccountSummaryTitle() complete");
	}

	@Test
	public void verifyCashAccountsLabelisDisplayed() {
		accountSummary.verifyCashAccountsLabel();
	}

	//navigate to the accounts activity page!
	@Test
	public void getAccountActivityPage() throws InterruptedException {
		accountSummary.clickMyAccountActivity();
		Thread.sleep(2000);
	}

	
//	@Test
//	public void verifyCheckAccountSummaryButtonSelected() {
//		Assert.assertTrue(accountSummary.checkAccountSummaryButtonSelected());
//		System.out.println("checkAccountSummaryButtonSelected() Complete");
//	}

	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
 } // end of class


