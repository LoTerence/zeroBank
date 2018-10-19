package zeroBank.testcases;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import zeroBank.base.TestBase;
import zeroBank.pages.HomePage;
import zeroBank.pages.LoginPage;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.PayBillsPage;
import zeroBank.util.TestUtil;

public class PayBillsTest extends TestBase {

	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	AccountSummary summaryPage;
	PayBillsPage pbp;
	
	@BeforeMethod
	public void setUp() {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage = homePage.clickSignIn();
		summaryPage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		pbp = summaryPage.clickPayBills();
	}

	//test a successful payment will show appropriate alert message
	@Test
	public void verifySuccessfulPayment() {
		pbp.paySavedPayee("Spring", "Savings", 20, "2018-10-21", "a description");
		pbp.clickPayButton();
		Assert.assertTrue(pbp.verifyPayment());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("test complete...");
	}

}
