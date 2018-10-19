package zeroBank.testcases;

import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import zeroBank.base.TestBase;
import zeroBank.pages.AccountActivity;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.HomePage;
import zeroBank.pages.LoginPage;
import zeroBank.pages.MyMoneyMap;
import zeroBank.pages.PayBillsPage;
import zeroBank.util.TestUtil;

public class MyMoneyMapTest extends TestBase {
	
	//AccountActivity activityPage;
	AccountSummary summaryPage;
	//PayBillsPage payBillsPage;
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	MyMoneyMap myMoneyMap;
	String sheetName = "MyMoneyMap Toggles";
	
	public MyMoneyMapTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		//activityPage = new AccountActivity();
		//payBillsPage = new PayBillsPage();
		homePage = new HomePage();
		loginPage = homePage.clickSignIn();
		summaryPage = loginPage.signIn(prop.getProperty("username"), prop.getProperty("password"));
		myMoneyMap = summaryPage.clickMyMoneyMap();
		
	}
	
	@Test
	public void verifyMyMoneyMapZeroLogo() {
		// checks to see if Zero Logo is in the corner of the page
		Assert.assertTrue(myMoneyMap.verifyZeroLogo(), "Logo is not displayed");
	}
	
	@Test
	public void validateMyMoneyMapTitle() {
		// asserts that the page has been navigated to
		Assert.assertTrue(myMoneyMap.verifyTitle());
	}
	
	
	//Tests logout link
	@Test
	public void logoutTest() {
		homePage = myMoneyMap.logOut();
		Assert.assertEquals(
				homePage.validateHomePageTitle(), "Zero - Personal Banking - Loans - Credit Cards", "Did not sign out correctly");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void wedgeStabilityTest() {
		String initialText = myMoneyMap.getWedge1Text();
		myMoneyMap.toggleOutFlowTableSort();
		String afterText = myMoneyMap.getWedge1Text();
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(initialText, afterText);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}

