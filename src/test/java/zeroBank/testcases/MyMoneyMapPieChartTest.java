package zeroBank.testcases;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import zeroBank.base.TestBase;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.HomePage;
import zeroBank.pages.LoginPage;
import zeroBank.pages.MyMoneyMap;
import zeroBank.util.TestUtil;

public class MyMoneyMapPieChartTest extends TestBase {
	
	//AccountActivity activityPage;
		AccountSummary summaryPage;
		//PayBillsPage payBillsPage;
		TestUtil testUtil;
		LoginPage loginPage;
		HomePage homePage;
		MyMoneyMap myMoneyMap;
		String sheetName = "MyMoneyMap Toggles";
		
		public MyMoneyMapPieChartTest() {
			super();
			
		}
		
		@BeforeTest
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
		
		@DataProvider
		public Object[][] getMyMoneyMapTestData() throws InvalidFormatException{
			// loads all button names
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		@Test(dataProvider="getMyMoneyMapTestData")
		public void validateToggleOff(String wedgeName) {
			myMoneyMap.toggleWedge(wedgeName);
			Assert.assertFalse(myMoneyMap.isDisplayedOnPie(wedgeName), wedgeName+" wedge is still displayed.");
			myMoneyMap.toggleWedge(wedgeName);
			Assert.assertTrue(myMoneyMap.isDisplayedOnPie(wedgeName), wedgeName + " wedge did not reappear.");
		}
		
//		@Test(dataProvider="getMyMoneyMapTestData")
//		public void validateToggle_OnAndOff(String wedgeName) {
//			myMoneyMap.toggleWedge(wedgeName);
//			myMoneyMap.toggleWedge(wedgeName);
//			Assert.assertTrue(myMoneyMap.isDisplayedOnPie(wedgeName), wedgeName + " wedge did not reappear.");
//		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
		

}
