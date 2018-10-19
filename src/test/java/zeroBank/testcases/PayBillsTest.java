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
	public void successfulPayment() {
		pbp.paySavedPayee("Sprint", "Savings", "20", "2018-10-21", "a description");
		pbp.clickPayButton();
		Assert.assertTrue(pbp.verifySuccess());
	}
	
	//test pay saved payee - amount should not be <0
	@Test
	public void payNegativeAmount() {
		pbp.paySavedPayee("Sprint", "Savings", "-1", "2018-10-21", "a description");
		pbp.clickPayButton();
		Assert.assertTrue(!pbp.verifySuccess());
	}

	//test pay saved payee - amount should not be == 0
	@Test
	public void payZeroAmount() {
		pbp.paySavedPayee("Sprint", "Savings", "0", "2018-10-21", "a description");
		pbp.clickPayButton();
		Assert.assertTrue(!pbp.verifySuccess());
	}

	//test pay saved payee - amount should not be empty
	@Test
	public void payEmptyAmount() {
		pbp.paySavedPayee("Sprint", "Savings", "", "2018-10-21", "a description");
		pbp.clickPayButton();
		Assert.assertTrue(!pbp.verifySuccess());
	} 
	
	//test for successfully adding new payee
	@Test
	public void successfulAddPayee() {
		pbp.clickAddNewPayeeLink();
		pbp.addNewPayee("Paul", "123 Real St", "Apple", "Some details");
		pbp.clickAddButton();
		Assert.assertTrue(pbp.verifySuccess());
	}
	
	@Test
	public void emptyFieldsAddPayee() {
		pbp.clickAddNewPayeeLink();
		pbp.addNewPayee("", "", "", "");
		pbp.clickAddButton();
		Assert.assertTrue(!pbp.verifySuccess());
	}
	
	//test for successfully purchasing foreign currency 
	@Test
	public void successfulFCPurchase() {
		pbp.clickPurchaseForCurrLink();
		pbp.purchaseForeignCurrency("CAD", "100", "USD");
		pbp.clickPurchaseButton();
		Assert.assertTrue(pbp.verifySuccess());
	}
	
	//test for successfully purchasing foreign currency. should not be negative 
	@Test
	public void negativeFCPurchase() {
		pbp.clickPurchaseForCurrLink();
		pbp.purchaseForeignCurrency("AUD", "-100", "AUD");
		pbp.clickPurchaseButton();
		Assert.assertTrue(!pbp.verifySuccess());
	}
	
	//test for successfully purchasing foreign currency. should not be empty amount 
	@Test
	public void emptyFCPurchase() {
		pbp.clickPurchaseForCurrLink();
		pbp.purchaseForeignCurrency("CNY", "", "");
		pbp.clickPurchaseButton();
		pbp.handleAlert();
		Assert.assertTrue(!pbp.verifySuccess());
	}

	//test for successfully purchasing foreign currency. should not be zero amount 
	@Test
	public void zeroFCPurchase() {
		pbp.clickPurchaseForCurrLink();
		pbp.purchaseForeignCurrency("CNY", "0", "USD");
		pbp.clickPurchaseButton();
		pbp.handleAlert();
		Assert.assertTrue(!pbp.verifySuccess());
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("test complete...");
	}

}
