package zeroBank.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import zeroBank.base.TestBase;
import zeroBank.pages.AccountSummary;
import zeroBank.pages.HomePage;
import zeroBank.pages.LoginPage;
import zeroBank.pages.MyMoneyMap;
import zeroBank.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	
	//AccountActivity activityPage;
	//AccountSummary summaryPage;
	//PayBillsPage payBillsPage;
	TestUtil testUtil;
	LoginPage loginPage;
	HomePage homePage;
	//MyMoneyMap myMoneyMap;

	
	public LoginPageTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage = homePage.clickSignIn();
	}
	
	@Test
	public void verifyLoginPageZeroLogo() {
		//checks the brand is displayed on the login page (top left)
		Assert.assertTrue(loginPage.verifyZeroLogo(), "login page logo not found");
		System.out.println("Zero Logo found...");
	}
	
	@Test
	public void verifyLoginPagetitle() {
		Assert.assertEquals(loginPage.validateLoginPageTitle(), "Zero - Log in");
		System.out.println("Login Page Title Validated...");
	}
	
	@Test
	public void errorMessageOnInvalid() {
		Assert.assertTrue(loginPage.errorMessageShown(), "Error message not shown");
		System.out.println("Error Messasge correctly shown...");
		
	}
	
	@Test 
	public void hoverMessageIsDisplayed() throws InterruptedException {
		Assert.assertTrue(loginPage.hoverForCredentialsShown(), "Error with hover");
		System.out.println("Hover Message Is Displayed...");
	}
	
	@Test public void verifyForgottenPasswordLink() {
		Assert.assertEquals(loginPage.clickForgotPassword(), "http://zero.webappsecurity.com/forgot-password.html");
		System.out.println("Forgotten Password Link verified...");
	}
	
	@Test
	public void checkBoxVerify() {
		Assert.assertTrue(loginPage.clickRememberMe(), "Missing remember me check box");
		System.out.println("Checkbox Verified...");
	}
	
	@Test
	public void loginVerify() {
		Assert.assertEquals(loginPage.correctLogin(), "Zero - Account Summary");
		System.out.println("Login Verified...");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("test complete...");
	}
	

}