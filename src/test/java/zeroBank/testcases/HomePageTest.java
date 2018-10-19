package zeroBank.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import zeroBank.base.TestBase;
import zeroBank.pages.HomePage;
import zeroBank.util.TestUtil;

public class HomePageTest extends TestBase {
	TestUtil testUtil;
	HomePage homePage;

	
	public HomePageTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		
	}
	
	@Test
	public void verifyHomePageZeroLogo() {
		//checks the brand is displayed on the login page (top left)
		Assert.assertTrue(homePage.verifyZeroLogo(), "login page logo not found");
		System.out.println("Home Page Zero Logo found...");
	}
	
	@Test
	public void verifyHomePageTitle() {
		Assert.assertEquals(homePage.validateHomePageTitle(), "Zero - Personal Banking - Loans - Credit Cards");
		System.out.println("Verfied Home Page Title...");
	}
	
	@Test
	public void verifysignInButton() {
		Assert.assertTrue(homePage.signInDisplayed(), "Signin button not found");
		System.out.println("Sign In button Found...");
	}
	
	@Test
	public void verifyOnlineBankingLink() {
		Assert.assertTrue(homePage.onlineBankingIsDisplayed(), "Online Banking button not found");
		System.out.println("OnlineBanking Link Found...");
	}
	
	@Test
	public void verifyAccountActivityLinkIsDisplayed() {
		Assert.assertTrue(homePage.accountActivityLinkIsDisplayed(), "Account activity Link not found");
		System.out.println("Account Activity Page Found...");
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("HomePageTest complete...");
	}
	

}

